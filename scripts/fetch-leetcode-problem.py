#!/usr/bin/env python3
"""
从 LeetCode CN 抓取题目信息，按题号查询，输出 JSON。
用法：python3 fetch-problem.py <题号>
"""
import sys
import json
import re
import urllib.request
import urllib.error
from html.parser import HTMLParser
from pathlib import PurePosixPath
from urllib.parse import unquote, urlparse

GRAPHQL_URL = 'https://leetcode.cn/graphql'
HEADERS = {
    # LeetCode GraphQL 会拒绝缺少浏览器上下文的最小化请求。
    # 这些头与 Chrome 从 leetcode.cn 页面发起的同源 JSON 请求一致；
    # 不伪造登录 Cookie，题目公开数据仍应可匿名获取。
    'Accept': 'application/json, text/plain, */*',
    'Accept-Language': 'zh-CN,zh;q=0.9,en;q=0.8',
    'Content-Type': 'application/json',
    'Origin': 'https://leetcode.cn',
    'Referer': 'https://leetcode.cn/problemset/',
    'Sec-Fetch-Dest': 'empty',
    'Sec-Fetch-Mode': 'cors',
    'Sec-Fetch-Site': 'same-origin',
    'User-Agent': ('Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) '
                   'AppleWebKit/537.36 (KHTML, like Gecko) '
                   'Chrome/140.0.0.0 Safari/537.36'),
}


def graphql(query, variables):
    payload = json.dumps({'query': query, 'variables': variables}).encode()
    req = urllib.request.Request(GRAPHQL_URL, data=payload, headers=HEADERS)
    with urllib.request.urlopen(req, timeout=10) as resp:
        return json.loads(resp.read())


def get_slug(num):
    """按题号搜索，返回 titleSlug。"""
    data = graphql(
        '''query problemList($filters: QuestionListFilterInput) {
            problemsetQuestionList(
                categorySlug: "all-code-essentials",
                limit: 100, skip: 0,
                filters: $filters
            ) {
                questions { frontendQuestionId titleSlug }
            }
        }''',
        {'filters': {'searchKeywords': str(num)}}
    )
    questions = data['data']['problemsetQuestionList']['questions']
    for q in questions:
        if q['frontendQuestionId'] == str(num):
            return q['titleSlug']
    return None


def get_problem(slug):
    """按 slug 获取题目详细信息。"""
    data = graphql(
        '''query getQuestion($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionFrontendId
                title
                titleSlug
                translatedTitle
                translatedContent
                difficulty
                metaData
            }
        }''',
        {'titleSlug': slug}
    )
    return data['data']['question']


def html_to_text(html):
    """简单将 HTML 转为纯文本。"""
    # IntelliJ 的 Markdown 预览不会渲染 <sub>，因此转换为跨渲染器可见的 Unicode 下标。
    subscript_chars = {
        '0': '₀', '1': '₁', '2': '₂', '3': '₃', '4': '₄',
        '5': '₅', '6': '₆', '7': '₇', '8': '₈', '9': '₉',
        '+': '₊', '-': '₋', '=': '₌', '(': '₍', ')': '₎',
        'a': 'ₐ', 'e': 'ₑ', 'h': 'ₕ', 'i': 'ᵢ', 'j': 'ⱼ',
        'k': 'ₖ', 'l': 'ₗ', 'm': 'ₘ', 'n': 'ₙ', 'o': 'ₒ',
        'p': 'ₚ', 'r': 'ᵣ', 's': 'ₛ', 't': 'ₜ', 'u': 'ᵤ',
        'v': 'ᵥ', 'x': 'ₓ',
    }

    def render_subscript(match):
        value = match.group(1)
        if all(char in subscript_chars for char in value):
            return ''.join(subscript_chars[char] for char in value)
        return '_' + value

    html = re.sub(r'<sub>(.*?)</sub>', render_subscript, html, flags=re.DOTALL)
    # LeetCode 题面偶尔会在 <code> 中直接使用未转义的 <=、>=。
    # 先暂存它们，避免通用标签正则将其误当成标签开头而吞掉范围条件。
    html = html.replace('<=', '__LE__').replace('>=', '__GE__')
    # <sup> 标签转为 ^ 符号
    html = re.sub(r'<sup>(.*?)</sup>', r'^\1', html)
    # <pre> 块保留换行
    html = re.sub(r'<pre>(.*?)</pre>', lambda m: '\n' + m.group(1) + '\n', html, flags=re.DOTALL)
    # 段落、列表项换行
    html = re.sub(r'<(?:p|li|br\s*/?)>(?!</)', '\n', html)
    html = re.sub(r'</(?:p|li|ul|ol)>', '\n', html)
    # 去掉其余标签
    html = re.sub(r'<[^>]+>', '', html)
    # HTML 实体
    html = (html
            .replace('&lt;', '<').replace('&gt;', '>')
            .replace('&amp;', '&').replace('&nbsp;', ' ')
            .replace('&#39;', "'").replace('&quot;', '"')
            .replace('__LE__', '<=').replace('__GE__', '>='))
    # 合并多余空行
    html = re.sub(r'\n{3,}', '\n\n', html)
    return html.strip()


def extract_images(html):
    """从 GraphQL 返回的题面 HTML 中提取图片元数据。"""
    class ImageParser(HTMLParser):
        def __init__(self):
            super().__init__()
            self.images = []

        def handle_starttag(self, tag, attrs):
            if tag != 'img':
                return
            attributes = dict(attrs)
            url = attributes.get('src')
            if not url:
                return
            filename = PurePosixPath(unquote(urlparse(url).path)).name
            self.images.append({
                'url': url,
                'alt': attributes.get('alt', ''),
                'filename': filename,
            })

    parser = ImageParser()
    parser.feed(html)
    return parser.images


def extract_examples(content_text):
    """从题目文本中提取示例输入输出（尽力而为）。"""
    examples = []
    blocks = re.findall(
        r'(?:示例|Example)\s*\d*[：:]\s*\n(.*?)(?=(?:示例|Example)\s*\d*[：:]|\Z)',
        content_text, re.DOTALL
    )
    for block in blocks:
        inp = re.search(r'输[入入][:：]\s*(.+)', block)
        out = re.search(r'输[出出][:：]\s*(.+)', block)
        if inp and out:
            examples.append({
                'input': inp.group(1).strip(),
                'output': out.group(1).strip(),
            })
    return examples


def parse_method_signature(meta_json):
    """从 metaData JSON 解析方法名、返回类型和参数列表（Java 风格）。"""
    try:
        meta = json.loads(meta_json)
        method_name = meta.get('name', 'solve')
        params = meta.get('params', [])
        ret = meta.get('return', {}).get('type', 'void')

        type_map = {
            'integer': 'int', 'integer[]': 'int[]', 'integer[][]': 'int[][]',
            'string': 'String', 'string[]': 'String[]',
            'boolean': 'boolean', 'double': 'double',
            'long': 'long', 'list<integer>': 'List<Integer>',
            'list<string>': 'List<String>', 'list<list<integer>>': 'List<List<Integer>>',
            'void': 'void', 'character': 'char', 'character[]': 'char[]',
        }

        def to_java(t):
            return type_map.get(t.lower(), t)

        param_str = ', '.join(f'{to_java(p["type"])} {p["name"]}' for p in params)
        return to_java(ret), method_name, param_str
    except Exception:
        return 'void', 'solve', 'Object input'


def main():
    if len(sys.argv) != 2 or not sys.argv[1].isdigit():
        print('用法：python3 fetch-problem.py <题号>', file=sys.stderr)
        sys.exit(1)

    num = int(sys.argv[1])
    padded = f'{num:04d}'

    print(f'[1/2] 查找第 {num} 题的 titleSlug...', file=sys.stderr)
    slug = get_slug(num)
    if not slug:
        print(f'错误：找不到第 {num} 题', file=sys.stderr)
        sys.exit(1)

    print(f'[2/2] 获取题目详情（{slug}）...', file=sys.stderr)
    problem = get_problem(slug)

    content_html = problem.get('translatedContent') or ''
    images = extract_images(content_html)
    content_cn = html_to_text(content_html)
    examples = extract_examples(content_cn)
    ret_type, method_name, params = parse_method_signature(problem.get('metaData', '{}'))

    result = {
        'num': num,
        'padded': padded,
        'slug': slug,
        'titleCn': problem.get('translatedTitle', problem['title']),
        'titleEn': problem['title'],
        'difficulty': problem['difficulty'],
        'contentCn': content_cn,
        'images': images,
        'examples': examples,
        'returnType': ret_type,
        'methodName': method_name,
        'params': params,
    }

    print(json.dumps(result, ensure_ascii=False))


if __name__ == '__main__':
    main()
