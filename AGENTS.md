<!-- Generated: 2026-05-16 -->

# exercises-algorithm

## Purpose

算法练习项目。扁平 Maven 多模块结构：所有练习模块直接挂根 POM，无嵌套聚合层。LeetCode 按题号段分模块，数据结构与算法独立模块。

## Key Files

| File | Description |
|------|-------------|
| `pom.xml` | 父 POM，`<modules>` 列出所有模块，统一依赖版本 |
| `CLAUDE.md` | 构建命令、包名约定、模块结构说明 |

## Module Map

### LeetCode 练习
`leet-code_1-50` · `leet-code_51-100` · `leet-code_101-150` · `leet-code_151-200` · `leet-code_201-250` · `leet-code_251-300` · `leet-code_301-350` · `leet-code_351-400` · `leet-code_401-450` · `leet-code_451-500` · `leet-code_501-550` · `leet-code_551-600` · `leet-code_601-650` · `leet-code_651-700` · `leet-code_801-850` · `leet-code_901-950` · `leet-code_951-1000` · `leet-code_1101-1150` · `leet-code_1201-1250` · `leet-code_1351-1400`

### CTCI 面试题
`CTCI-01`

### 数据结构与算法
`common-algorithm` · `data-structure`

### 其他
`data` · `leet-code-grap`

## Package Naming

| 模块 | 包前缀 |
|------|--------|
| `leet-code_*` | `manfred.exercises.leetcode.pXXX`（题号3位补零） |
| `CTCI-01` | `manfred.exercises.ctci.cXX` |
| `common-algorithm` | `manfred.exercises.algorithm.*` |
| `data-structure` | `manfred.exercises.datastructure.*` |
| `leet-code-grap` | `manfred.exercises.leetcode.grap.*` |
| `data` | `manfred.exercises.*` |

## For AI Agents

### Working In This Directory

- 所有 `mvn` 命令必须附加 `-Dsort.skip=true`
- 编译命令：`mvn clean compile -DskipTests -Dsort.skip=true`
- 新增题目：在对应题号段模块的 `src/main/java/manfred/exercises/leetcode/pXXX/` 下创建文件，不需要修改 pom.xml
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
