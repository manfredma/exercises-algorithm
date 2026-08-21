# exercises-algorithm

算法练习项目，Maven 扁平多模块结构：所有练习模块直接挂根 POM，无嵌套聚合层。LeetCode 560+ 题合并为单一模块，数据结构与算法独立模块。

- groupId: `manfred.end`，artifactId: `exercises-algorithm`，version: `1.0-SNAPSHOT`
- Java 版本: 8

> 本文件是项目的**单一事实源**入口。`CLAUDE.md` 通过 `@AGENTS.md` 自动加载本文件。详细 SOP（如 LeetCode 各生命周期流程）以独立文档形式按需查阅，见下表 Key Files，不常驻上下文。

## Key Files（指南针）

| File | Description |
|------|-------------|
| `pom.xml` | 父 POM，`<modules>` 列出所有模块，统一依赖版本 |
| `CLAUDE.md` | Claude Code 入口，通过 `@AGENTS.md` 加载本文件 |
| `docs/leetcode-content-spec.md` | 题面抓取与规范（共享）：fetch 脚本、readme/Main 注释规范、图片、验证核对 |
| `docs/leetcode-init-workflow.md` | 初始化新题流程（wip 空骨架 + 题面 + Main 用例） |
| `docs/leetcode-refresh-workflow.md` | 重刷已解决题流程（拉回 wip + 新骨架 + 迁用例） |
| `docs/leetcode-finish-workflow.md` | 完成收尾与提交流程（SOP 8 步 + 归档 + 提交，`/finish-leetcode`） |
| `docs/leetcode-template-conventions.md` | 三道模板（p3069/p3096/p0257）的写法规范要点，初始化新题的成品参照 |
| `scripts/fetch-leetcode-problem.py` | 从 LeetCode 中文站 GraphQL 抓取题目元数据的本地脚本，按题号查询，输出 JSON |
| `scripts/leetcode-segment.py` | 按题号算归档段目录与 package 声明，校验 wip/solved 现状；归档前必跑，禁止口算段目录 |

## 项目结构

```
exercises-algorithm/
├── pom.xml              ← 父 POM，统一依赖版本管理
├── leet-code/           ← LeetCode 全部题目（560+ 题，题号 1–3200）
├── ctci/                ← 《Cracking the Coding Interview》第1章面试题
├── common-algorithm/    ← 常用算法（排序、字符串匹配、动态规划、图）
├── data-structure/      ← 数据结构（堆、BST、红黑树、图）
├── leet-code-grap/      ← LeetCode 图算法专题
└── data/                ← 数据读写工具类练习
```

## 模块职责

- **LeetCode 练习** `leet-code`：560+ 题，题号 1–3200
- **CTCI 面试题** `ctci`：《Cracking the Coding Interview》第1章
- **数据结构与算法** `common-algorithm` · `data-structure`
- **其他** `data` · `leet-code-grap`

## 包名约定

| 模块 | 包前缀 |
|------|--------|
| `leet-code` 已完成题目 | `manfred.exercises.leetcode.solved.pXXXXtoYYYY.pZZZZ`（题号4位补零，如 `p0328`） |
| `leet-code` 进行中题目 | `manfred.exercises.leetcode.wip.pXXXX`（题号4位补零，如 `p0735`） |
| `ctci` | `manfred.exercises.ctci.cXXXX`（前两位章节+后两位题号，如 `c0101`） |
| `common-algorithm` | `manfred.exercises.algorithm.*` |
| `data-structure` | `manfred.exercises.datastructure.*` |
| `leet-code-grap` | `manfred.exercises.leetcode.grap.*` |
| `data` | `manfred.exercises.*` |

> 题号格式：LeetCode 补零到4位（`p0001`），CTCI 前两位为章节、后两位为题号（`c0101`）。题目按状态与题号段归档：已完成位于 `solved/pXXXXtoYYYY/pZZZZ/`，进行中位于 `wip/pZZZZ/`。

## 每题目录约定

每道 LeetCode 题目目录包含：

- `Solution.java` — 主要解法
- `Solution2.java` / `SolutionV2.java` — 备选解法（按需）
- `Main.java` — 测试入口（有 `public static void main(String[] args)`）
- `TreeNode.java` / `ListNode.java` — 题目辅助数据结构（按需）

## For AI Agents

### 构建

所有 `mvn` 命令必须附加 `-Dsort.skip=true`（防 sortpom 重排）。构建命令（compile/test/package/install）前加 `clean`；纯查询（`dependency:list`、`dependency:tree`）无需 `clean`。

```bash
# 编译所有模块
mvn clean compile -DskipTests -Dsort.skip=true
# 编译单个模块
mvn clean compile -pl leet-code -Dsort.skip=true
# 运行测试
mvn clean test -Dsort.skip=true
```

### LeetCode 题目

- 新题一律初始化在 `leet-code/src/main/java/manfred/exercises/leetcode/wip/pXXXX/`，包名 `manfred.exercises.leetcode.wip.pXXXX`，无需改 `pom.xml`。只有完成实现并通过 `Main` 验证后才归档到题号所在的 `solved` 百题段（段目录由 `scripts/leetcode-segment.py` 计算，不得口算；见 `docs/leetcode-finish-workflow.md` 步骤 5），并同步更新 package 声明与跨题 import。不得将空骨架或仍在修改的题目放入 `solved`，也不得把已完成题目长期保留在 `wip`。
- **题面抓取、README/题面注释、图片、验证的统一规范见 `docs/leetcode-content-spec.md`**（抓题/刷新题面前必读）；成品写法模板（Solution/Main/readme 结构）见 `docs/leetcode-template-conventions.md`，以 p3069 / p3096 / p0257 为参照；生命周期流程按场景查阅：初始化新题 → `docs/leetcode-init-workflow.md`，重刷已解决题（拉回 wip + 新骨架） → `docs/leetcode-refresh-workflow.md`，完成收尾与归档提交 → `docs/leetcode-finish-workflow.md`（SOP 8 步；Claude Code 可用 `/finish-leetcode <题号>`）。
- 抓取用 `scripts/fetch-leetcode-problem.py`（走 LeetCode 中文站 GraphQL），以远程数据为唯一来源；抓取失败、超时或字段不完整时不得凭记忆、摘要或第三方题面补全。仅刷新题面格式（不重刷解法）时，只跑 fetch 重写 `readme.md`，不动位置、package、`Solution.java`、`Main.java`。
- Solution 类通常是 package-private（无 public 修饰），Main 类是 public 且有 `main` 方法；辅助数据结构（TreeNode、ListNode）定义在各自题目包下，跨题引用时直接 import。
- 所有测试统一写在对应题目的 `Main.main` 中；禁止在 `leet-code/src/test/java` 下新增或保留 JUnit/TestNG 测试类，禁止在 `src/main/java` 下使用 `@Test` 注解。断言用 `exercise-assert` 模块的 `Assert`（`import static`），**新题与重刷题默认用带 desc 重载**（`assertEquals(expected, actual, "input=..."`），失败信息含用例内容与行号，规范见 [`docs/leetcode-content-spec.md`](docs/leetcode-content-spec.md)「Main 断言规范」节。`Main` 的题目链接必须放进 imports 后、紧贴类声明的 Javadoc，使用 `@see <a href="https://leetcode.cn/problems/{slug}/">LeetCode 中文站</a>`；不得保留孤立的题目链接文档注释。

### Java 8 约束

`Solution.java` 与 `Main.java` 禁止使用 Java 9+ API：`List.of()`/`Map.of()`/`Set.of()` → `Arrays.asList()`；禁 `var` 关键字；禁 `String.isBlank()`、`Optional.ifPresentOrElse()` 等 Java 9+ 方法。

### 收尾 SOP

每道 LeetCode 题目解法实现后、提交前，必须按 `docs/leetcode-finish-workflow.md` 顶部的「完成一题的收尾 SOP」清单逐项执行（补注释 → 补用例 → 编译 → 运行验证 → 归档 → 改 package → 归档后复验 → 更新 HOT100 进度 → 暂存提交推送）。未完成（Solution 仍空骨架、Main 有失败用例）的题目不得归档，留在 `wip` 并说明原因。Claude Code 可用 `/finish-leetcode <题号>` 命令执行其中机械步骤；注释与用例需人工判断。

**归档前注释自检（机械步骤，不得靠记忆）**：归档迁移目录前，对该题所有 `.java` 跑一次占位/过时注释扫描，确认无残留才归档：

```bash
grep -rnE "再刷骨架|待填充|待实现|骨架占位|RED，待实现" wip/pXXXX/*.java
```

- 命中即说明某 Solution 的类 Javadoc 仍是骨架占位，或 Main 仍有「骨架占位下 RED，待实现后通过」之类过时注释——归档前必须改掉。
- 仅凭「Main 编译运行全绿」不能代替此项：Main 通过 ≠ 注释齐全，二者是独立校验项。
- 历史上多次在归档后才发现某 Solution Javadoc 漏改（0008、0150 等），故必须用 grep 机械核验而非记忆。

### 跨工具通用性约束（重要）

项目特定知识、规则、SOP 必须写在**仓库内**（`AGENTS.md`、`docs/`、`CLAUDE.md` 等），不得记录到 Claude Code 的私有记忆（`~/.claude/.../memory/`）。原因：私有记忆仅 Claude Code 可读，切换到 Codex 或其他 AI agent 时无法继承，会造成规则丢失。仓库内文件是所有 agent 的单一事实源。Claude Code 私有记忆只用于记录「这个用户是谁、工作偏好」等跨项目通用的 agent 行为反馈，不存项目特定知识。

## Git 工作流

- 默认直接在 `main` 分支开发、提交和推送。
- 除非用户明确要求，否则不要创建或切换功能分支，也不要创建 Pull Request。
- 提交时按最小可独立验证的逻辑单元拆分；不要将无关变更合并为一个提交。
- 用户要求“提交”某道 LeetCode 题目时，必须先判断该题是否已完成：若解法已实现且对应 `Main` 验证通过，先将题目从 `wip` 归档到题号所在的 `solved` 百题段、更新 package 与跨题 import，再暂存、提交和推送；未完成的题目才保留在 `wip`，并在提交前说明原因。
