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
| `leet-code` | `manfred.exercises.leetcode.pXXXX`（题号4位补零，如 `p0001`） |
| `ctci` | `manfred.exercises.ctci.cXXXX`（前两位章节+后两位题号，如 `c0101`） |
| `common-algorithm` | `manfred.exercises.algorithm.*` |
| `data-structure` | `manfred.exercises.datastructure.*` |
| `leet-code-grap` | `manfred.exercises.leetcode.grap.*` |
| `data` | `manfred.exercises.*` |

## For AI Agents

### Working In This Directory

- 所有 `mvn` 命令必须附加 `-Dsort.skip=true`
- 编译命令：`mvn clean compile -DskipTests -Dsort.skip=true`
- 新增 LeetCode 题目：在 `leet-code/src/main/java/manfred/exercises/leetcode/pXXXX/` 下创建文件，不需要修改 pom.xml
- 新增 CTCI 题目：在 `ctci/src/main/java/manfred/exercises/ctci/cXXXX/` 下创建文件
- 父 POM 集中管理依赖版本，子模块 pom.xml 按需引用不写 `<version>`
- 每道题的 `Main.java` 必须有 `public static void main(String[] args)` 入口
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

## LeetCode 题目初始化一致性

- 题面、题目骨架必须以 LeetCode 中文站成功抓取的远程数据为唯一来源；抓取失败时不得凭记忆、摘要或其他来源生成。
- `readme.md` 与 `Main.java` 中的题面注释必须完整保留远程题面的描述、全部示例、解释和提示；禁止压缩、简写、概括、遗漏或自行改写题面规则。
- `Solution.java` 的方法签名、参数和返回类型，以及设计题的类、构造器和操作方法，必须与远程题面保持一致；初始化阶段只保留空骨架，不添加解法。
- 远程题面图片必须下载到题目目录并以本地相对路径引用，不得省略或直接使用远程图片链接。
- 初始化 `Main.java` 时，必须为远程题面的全部示例建立可执行断言；并补充覆盖单元素、空/极值、边界、并列结果及典型特殊结构等关键场景的测试用例（仅适用的场景），不能只保留少量示例。
