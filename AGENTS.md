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
