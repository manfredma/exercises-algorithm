# exercises-algorithm

算法与数据结构练习项目，Java 8，Maven 扁平多模块结构。

[English](README_EN.md)

## 项目结构

```
exercises-algorithm/
├── pom.xml              ← 父 POM，统一依赖版本管理
├── leet-code/           ← LeetCode 全部题目（560+ 题，第 1-1400 题）
├── ctci/                ← 《Cracking the Coding Interview》第1章面试题
├── common-algorithm/    ← 常用算法（排序、字符串匹配、动态规划、图）
├── data-structure/      ← 数据结构（堆、BST、红黑树、图）
├── leet-code-grap/      ← LeetCode 图算法专题
└── data/                ← 文件读写工具类练习
```

- `groupId`: `manfred.end`，`artifactId`: `exercises-algorithm`，`version`: `1.0-SNAPSHOT`
- Java 版本: 8

## 快速开始

```bash
# 编译所有模块
mvn clean compile -DskipTests -Dsort.skip=true

# 编译单个模块
mvn clean compile -pl leet-code -Dsort.skip=true

# 运行测试
mvn clean test -Dsort.skip=true
```

## 包名规范

| 类型 | 包名格式 | 示例 |
|------|---------|------|
| LeetCode 题解 | `manfred.exercises.leetcode.pXXXX` | `manfred.exercises.leetcode.p0001` |
| CTCI 面试题 | `manfred.exercises.ctci.cXXXX` | `manfred.exercises.ctci.c0101` |
| 算法实现 | `manfred.exercises.algorithm.*` | `manfred.exercises.algorithm.sort.quick` |
| 数据结构 | `manfred.exercises.datastructure.*` | `manfred.exercises.datastructure.tree.heap` |

> 题号格式：LeetCode 补零到4位（`p0001`），CTCI 前两位为章节、后两位为题号（`c0101`）。

## 每题目录约定

每道 LeetCode 题目在对应包下：
- `Solution.java` — 主要解法
- `Solution2.java` / `SolutionV2.java` — 备选解法（按需）
- `Main.java` — 测试入口（含 `main` 方法）
- `TreeNode.java` / `ListNode.java` — 题目辅助数据结构（按需）

## 添加新题目

1. 在 `leet-code/src/main/java/manfred/exercises/leetcode/p0055/` 下创建文件
2. 不需要修改 `pom.xml`（模块已注册）
