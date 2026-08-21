# LeetCode 题目写法模板规范

本文收拢三道「项目写法模板」题（p3069 / p3096 / p0257）的成品写法要点，作为初始化新题时的统一参照。规则定义见 [`leetcode-content-spec.md`](leetcode-content-spec.md)（题面抓取与注释规范），收尾流程见 [`leetcode-finish-workflow.md`](leetcode-finish-workflow.md)（SOP 8 步），本文只给「成品长什么样」的具体模板与结构要点，不重复断言 API 细节与 SOP 步骤。

## 按题型参照模板

| 题型 | 参照模板 | 看什么 |
|------|---------|--------|
| 数组 / 字符串常规题 | `p3069` | 通用标杆，四项（Solution/Main/readme/一致性）全达标 |
| 需数学推导的题 | `p3096` | Solution Javadoc 用 `<p>` 段展开公式推导（如 `2*alice > total`） |
| 树 / 图题 | `p0257` | `treeOf(Integer...)` 层序建树工具、`assertPaths` 顺序无关断言、本地图片引用 |

> 三道均为单解法；多解法（`Solution2` / `SolutionV2`）的演进关系写法目前无现成模板，需时新立一题补充。

## Solution Javadoc 规范

类级 Javadoc 必须含三要素：**思路 + 关键点 + 时间/空间复杂度**。

- 常规题思路一段即可（参 `p3069`：双端填充 + left/right 指针 + 反转右半段）。
- 涉及数学/状态推导的题，用多个 `<p>` 段逐步展开公式（参 `p3096`：题意概述 → 前缀和公式 `2 * alice > total` → 复杂度）。
- 复杂度行明写出推导依据，如 `时间复杂度 O(n)，空间复杂度 O(1)（两趟扫描，仅累计标量，不额外建前缀和数组）`。
- 树/图题保留 LeetCode 原题的 `Definition` 注释块，用 `<pre>` 包裹（参 `p0257`）。
- 不得只留原题 `Definition` 注释、TODO 占位或一行题面。

## Main Javadoc 规范

`@see <a href="https://leetcode.cn/problems/{slug}/">LeetCode 中文站</a>` 紧贴 `public class Main` 声明，使用本次抓取的同一 `slug`：

```java
import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 XXXX 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/{slug}/">LeetCode 中文站</a>
 */
public class Main {
```

不得使用旧的 `/** 题目链接：URL */` 简写（`p1249`、`p1614` 等历史题沿用此格式，新题不再用）。

## Main 用例规范

- 覆盖官方全部示例 + 适用边界用例（单元素 / 空 / 极值 / 并列 / 特殊结构，依题而定）。
- 断言用 `exercise-assert` 模块 `Assert` 的**带 desc 重载**，desc 含输入（断言 API 与 desc 格式见 [`content-spec.md`](leetcode-content-spec.md)「Main 断言规范」）。
- `main` 末尾打印 `leet#XXXX passed`（4 位题号）。
- 树题结果允许任意顺序返回时，写辅助方法排序后比较（参 `p0257` 的 `assertPaths`：两边排序再 `assertEquals`）。
- 建树用层序工具 `treeOf(Integer...)`（`null` 表空位，参 `p0257`），避免逐节点手动拼接。
- 多解法时新旧解法均带 desc，desc 含解法标识与输入（如 `"Solution2 nums=[1,4,3,3,2]"`）。

## readme 结构规范（p3069 格式）

统一采用以下结构：

```
# 纯标题

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/{slug}/)

题面正文（完整保留，不概括或改写）

## 示例 1

```text
输入：...
输出：...
解释：...
```

## 示例 2

```text
...
```

## 提示

- `1 <= n <= 50`
- ...
```

要点：

- **标题**：`# 纯标题`（不含题号、不含难度行）。
- **链接行**：`> 题目链接：...` 置于标题下（content-spec「README 标题下…写入链接」）。
- **示例**：用 `## 示例 N` 二级标题（结构化，可生成目录），示例内容放 `text` 代码块；不用 `示例 N：` 纯文本。
- **提示**：用 `## 提示` 二级标题，列表项。
- **图片**：若原题有图，下载到 `wip/pXXXX/images/`，README 用本地相对路径 `![alt](images/xxx)` 引用，置于原题对应位置（参 `p0257`）；不保留 LeetCode 外链。
- **Markdown 特殊字符**：运算符等用行内代码，HTML 下标转 Unicode（脚本输出已转换）。

> `p0257` 的 readme 排版（链接在标题前、`示例 N：` 纯文本、含难度行）为历史保留，新题统一用 p3069 格式。
