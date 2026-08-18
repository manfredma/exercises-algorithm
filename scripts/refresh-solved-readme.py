#!/usr/bin/env python3
"""批量重抓 solved 题目 readme.md，按 docs/leetcode-content-spec.md 规范生成。

调 scripts/fetch-leetcode-problem.py 走 GraphQL 按题号抓取，把 contentCn
格式化为 readme：示例入 text 代码块、提示转列表、链接+标题。图片题下载
图片但不自动插图位置（contentCn 丢失原位置，留待手工定位）。

用法：
  python3 scripts/refresh-solved-readme.py --dry-run --only 1,200,1143
  python3 scripts/refresh-solved-readme.py --sample 5
  python3 scripts/refresh-solved-readme.py            # 全量
"""
import sys, json, subprocess, re, time, urllib.request, argparse
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SOLVED = ROOT / "leet-code/src/main/java/manfred/exercises/leetcode/solved"
FETCH = ROOT / "scripts/fetch-leetcode-problem.py"


def fetch(num, retries=2):
    for attempt in range(retries + 1):
        try:
            r = subprocess.run([sys.executable, str(FETCH), str(num)],
                               capture_output=True, text=True, timeout=30)
            if r.returncode == 0 and r.stdout.strip():
                return json.loads(r.stdout)
        except Exception as e:
            print(f"[fetch {num} 异常] {e}", file=sys.stderr)
        if attempt < retries:
            time.sleep(5 * (attempt + 1))
    return None


def format_readme(data):
    slug = data["slug"]
    title = data["titleCn"]
    content = data["contentCn"]
    out = ["# " + title, "",
           "> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/" + slug + "/)", ""]

    pat = re.compile(r'^[ \t]*(示例\s*\d*\s*[：:]|提示\s*[：:]|进阶\s*[：:]|Example\s*\d*\s*[:：]|Constraints\s*[:：]?|Follow[-\s]?up\s*[:：]?)', re.M)
    markers = list(pat.finditer(content))

    if markers:
        _desc_raw = content[:markers[0].start()]
        desc = "\n".join(l for l in _desc_raw.split("\n") if l.strip()).strip()
        if desc:
            out += [desc, ""]
        for i, m in enumerate(markers):
            start = m.start()
            end = markers[i + 1].start() if i + 1 < len(markers) else len(content)
            seg = content[start:end]
            label = m.group(1)
            body = re.sub(r'^[ \t]*' + re.escape(label) + r'\s*[：:][ \t]*', '', seg, count=1).strip()
            if re.match(r'示例|Example', label):
                num_m = re.search(r'\d+', label)
                ex_title = "示例 " + num_m.group() if num_m else "示例"
                out += ["## " + ex_title, "", "```text", body, "```", ""]
            elif re.match(r'提示|Constraints', label):
                out += ["## 提示", ""]
                for line in body.split("\n"):
                    line = line.strip().lstrip("\t").strip()
                    if line:
                        out.append("- " + line)
                out.append("")
            elif re.match(r'进阶|Follow', label):
                out += ["## 进阶", "", body, ""]
    else:
        out += [content.strip(), ""]
    return "\n".join(out).strip() + "\n"


def download_images(data, prob_dir):
    img_dir = prob_dir / "images"
    for img in data.get("images", []):
        img_dir.mkdir(exist_ok=True)
        url = img["url"]
        fn = img["filename"]
        try:
            urllib.request.urlretrieve(url, str(img_dir / fn))
        except Exception as e:
            print(f"[图片下载失败 {fn}] {e}", file=sys.stderr)


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--sample", type=int, default=0)
    ap.add_argument("--dry-run", action="store_true")
    ap.add_argument("--only", type=str, default="")
    ap.add_argument("--sleep", type=float, default=3.0)
    args = ap.parse_args()

    only_set = set()
    if args.only:
        only_set = set(int(x) for x in args.only.split(","))

    count = 0
    skipped_img = 0
    for seg_dir in sorted(SOLVED.iterdir()):
        if not seg_dir.is_dir() or not re.match(r'p\d+to\d+', seg_dir.name):
            continue
        for prob_dir in sorted(seg_dir.iterdir()):
            if not prob_dir.is_dir() or not re.match(r'p\d+', prob_dir.name):
                continue
            num = int(prob_dir.name[1:])
            if only_set and num not in only_set:
                continue
            count += 1
            if args.sample and count > args.sample:
                break
            print(f"[{count}] {prob_dir.name} (题号 {num})...", file=sys.stderr)
            data = fetch(num)
            if not data:
                print(f"  跳过：fetch 失败", file=sys.stderr)
                continue
            readme = format_readme(data)
            if data.get("images"):
                download_images(data, prob_dir)
                skipped_img += 1
                print(f"  ⚠️ 含图，已下载图但 readme 未插图（待手工定位）", file=sys.stderr)
            if args.dry_run:
                print(f"--- {prob_dir.name} ---")
                print(readme)
            else:
                (prob_dir / "readme.md").write_text(readme, encoding="utf-8")
            time.sleep(args.sleep)
        if args.sample and count > args.sample:
            break
    print(f"完成。图片题待手工：{skipped_img}", file=sys.stderr)


if __name__ == "__main__":
    main()
