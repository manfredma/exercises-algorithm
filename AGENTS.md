<!-- Generated: 2026-05-16 -->

# exercises-algorithm

## Purpose

算法练习项目。扁平 Maven 多模块结构：所有练习模块直接挂根 POM，无嵌套聚合层。LeetCode 560+ 题合并为单一模块，数据结构与算法独立模块。

## Key Files

| File | Description |
|------|-------------|
| `pom.xml` | 父 POM，`<modules>` 列出所有模块，统一依赖版本 |
| `CLAUDE.md` | 构建命令、包名约定、模块结构说明 |

## Module Map

### LeetCode 练习
`leet-code`（560+ 题，第 1-1400 题）

### CTCI 面试题
`ctci`（《Cracking the Coding Interview》第1章）

### 数据结构与算法
`common-algorithm` · `data-structure`

### 其他
`data` · `leet-code-grap`

## Package Naming

| 模块 | 包前缀 |
|------|--------|
| `leet-code` 已完成题目 | `manfred.exercises.leetcode.solved.pXXXXtoYYYY.pZZZZ`（题号4位补零，如 `p0328`） |
| `leet-code` 进行中题目 | `manfred.exercises.leetcode.wip.pXXXX`（题号4位补零，如 `p0735`） |
| `ctci` | `manfred.exercises.ctci.cXXXX`（前两位章节+后两位题号，如 `c0101`） |
| `common-algorithm` | `manfred.exercises.algorithm.*` |
| `data-structure` | `manfred.exercises.datastructure.*` |
| `leet-code-grap` | `manfred.exercises.leetcode.grap.*` |
| `data` | `manfred.exercises.*` |

## For AI Agents

### Working In This Directory

- 所有 `mvn` 命令必须附加 `-Dsort.skip=true`
- 编译命令：`mvn clean compile -DskipTests -Dsort.skip=true`
- 新增 LeetCode 题目：在 `leet-code/src/main/java/manfred/exercises/leetcode/wip/pXXXX/` 下创建文件，包名为 `manfred.exercises.leetcode.wip.pXXXX`，不需要修改 pom.xml
- LeetCode 题目完成并通过验证后，必须迁移到 `leet-code/src/main/java/manfred/exercises/leetcode/solved/pXXXXtoYYYY/pZZZZ/`；`XXXX` 至 `YYYY` 是题号所在的连续百题段（例如第 328 题归入 `p0301to0400/p0328`），并同步更新该题所有 Java 文件的 package 声明及跨题 import。
- 新增 CTCI 题目：在 `ctci/src/main/java/manfred/exercises/ctci/cXXXX/` 下创建文件
- 父 POM 集中管理依赖版本，子模块 pom.xml 按需引用不写 `<version>`
- 每道题的 `Main.java` 必须有 `public static void main(String[] args)` 入口
- LeetCode 题目的所有测试都必须写在对应题目的 `Main.main` 中；不得在 `leet-code/src/test/java` 下新增或保留 JUnit/TestNG 测试类。
- 不允许在 `src/main/java` 下使用 `@Test` 注解

### Testing Requirements

```bash
mvn clean test -Dsort.skip=true
```

### Common Patterns

- Solution 类通常是 package-private（无 public 修饰）
- Main 类是 public，有 main 方法
- 辅助数据结构（TreeNode、ListNode）定义在各自题目包下，跨题引用时直接 import

<!-- MANUAL: -->

## Git 工作流

- 默认直接在 `main` 分支开发、提交和推送。
- 除非用户明确要求，否则不要创建或切换功能分支，也不要创建 Pull Request。
- 提交时按最小可独立验证的逻辑单元拆分；不要将无关变更合并为一个提交。
- 用户要求“提交”某道 LeetCode 题目时，必须先判断该题是否已完成：若解法已实现且对应 `Main` 验证通过，先将题目从 `wip` 归档到题号所在的 `solved` 百题段、更新 package 与跨题 import，再暂存、提交和推送；未完成的题目才保留在 `wip`，并在提交前说明原因。

## LeetCode 题目初始化一致性

- 新题一律初始化在 `wip`；只有完成实现并验证后才归档到 `solved`。不得将空骨架或仍在修改的题目放入 `solved`，也不得把已完成题目长期保留在 `wip`。
- 题面、题目骨架必须以 LeetCode 中文站成功抓取的远程数据为唯一来源；抓取失败时不得凭记忆、摘要或其他来源生成。
- `readme.md` 与 `Main.java` 中的题面注释必须完整保留远程题面的描述、全部示例、解释和提示；禁止压缩、简写、概括、遗漏或自行改写题面规则。
- 每道 LeetCode 题目的 `readme.md` 与 `Main.java` 都必须保留对应的 LeetCode 中文站链接，格式分别为 `> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/{slug}/)` 和 `/** 题目链接：https://leetcode.cn/problems/{slug}/ */`。
- `readme.md` 必须将题面中的 Markdown 特殊字符按字面量展示；正文中的运算符等字符应优先置于行内代码（如 `*`），普通文本中的特殊字符才使用 Markdown 转义；示例中的特殊字符应置于代码块，禁止因渲染而隐藏、改变或额外显示转义符。
- `readme.md` 必须将题面中的下标按 Unicode 下标保留（如 `Rᵢ`、`Cⱼ`）；不得压缩为普通字符，也不得使用 IntelliJ Markdown 预览会原样显示的 HTML `<sub>` 标签。
- `Solution.java` 的方法签名、参数和返回类型，以及设计题的类、构造器和操作方法，必须与远程题面保持一致；初始化阶段只保留空骨架，不添加解法。
- 远程题面图片必须下载到题目目录并以本地相对路径引用，不得省略或直接使用远程图片链接。
- `readme.md` 中的题面图片必须按 LeetCode 中文站原始题面的位置嵌入相应内容；不得为方便处理而统一追加到文末或调整到无关位置。
- 初始化 `Main.java` 时，必须为远程题面的全部示例建立可执行断言；并补充覆盖单元素、空/极值、边界、并列结果及典型特殊结构等关键场景的测试用例（仅适用的场景），不能只保留少量示例。
