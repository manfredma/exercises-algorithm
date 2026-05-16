# exercises-algorithm

算法练习项目，Maven 扁平多模块结构。

## 项目结构

```
exercises-algorithm/
├── pom.xml                  ← 父 POM，统一依赖版本管理
├── leet-code_1-50/          ← LeetCode 第 1-50 题
├── leet-code_51-100/        ← LeetCode 第 51-100 题
├── leet-code_101-150/       ← LeetCode 第 101-150 题
├── leet-code_151-200/       ← LeetCode 第 151-200 题
├── leet-code_201-250/       ← LeetCode 第 201-250 题
├── leet-code_251-300/       ← LeetCode 第 251-300 题
├── leet-code_301-350/       ← LeetCode 第 301-350 题
├── leet-code_351-400/       ← LeetCode 第 351-400 题
├── leet-code_401-450/       ← LeetCode 第 401-450 题
├── leet-code_451-500/       ← LeetCode 第 451-500 题
├── leet-code_501-550/       ← LeetCode 第 501-550 题
├── leet-code_551-600/       ← LeetCode 第 551-600 题
├── leet-code_601-650/       ← LeetCode 第 601-650 题
├── leet-code_651-700/       ← LeetCode 第 651-700 题
├── leet-code_801-850/       ← LeetCode 第 801-850 题
├── leet-code_901-950/       ← LeetCode 第 901-950 题
├── leet-code_951-1000/      ← LeetCode 第 951-1000 题
├── leet-code_1101-1150/     ← LeetCode 第 1101-1150 题
├── leet-code_1201-1250/     ← LeetCode 第 1201-1250 题
├── leet-code_1351-1400/     ← LeetCode 第 1351-1400 题
├── CTCI-01/                 ← CTCI 面试题 Chapter 1
├── common-algorithm/        ← 常用算法（排序、字符串匹配、动态规划、图）
├── data-structure/          ← 数据结构（堆、BST、红黑树、图）
├── data/                    ← 数据读写工具类练习
└── leet-code-grap/          ← LeetCode 图算法专题
```

- `groupId`: `manfred.end`，`artifactId`: `exercises-algorithm`，`version`: `1.0-SNAPSHOT`
- Java 版本: 8
- 包名规范: `manfred.exercises.leetcode.pXXX`（题号补零到3位）

## 构建命令

```bash
# 编译所有模块（必须加 -Dsort.skip=true）
mvn clean compile -DskipTests -Dsort.skip=true

# 编译单个模块
mvn clean compile -pl leet-code_1-50 -Dsort.skip=true

# 运行测试
mvn clean test -Dsort.skip=true
```

## 包名约定

| 类型 | 包名格式 | 示例 |
|------|---------|------|
| LeetCode 题解 | `manfred.exercises.leetcode.pXXX` | `manfred.exercises.leetcode.p001` |
| CTCI 面试题 | `manfred.exercises.ctci.cXX` | `manfred.exercises.ctci.c01` |
| 算法实现 | `manfred.exercises.algorithm.*` | `manfred.exercises.algorithm.sort.quick` |
| 数据结构 | `manfred.exercises.datastructure.*` | `manfred.exercises.datastructure.tree.heap` |

## 每题目录约定

每道 LeetCode 题目在对应模块的包下：
- `Solution.java` — 主要解法
- `Solution2.java` / `SolutionV2.java` — 备选解法
- `Main.java` — 测试入口（有 `main` 方法）
- `TreeNode.java` / `ListNode.java` — 题目辅助数据结构（按需）

## 添加新题目

1. 确定题号所属模块（如第 55 题 → `leet-code_51-100`）
2. 在模块的 `src/main/java/manfred/exercises/leetcode/p055/` 下创建文件
3. 不需要修改 pom.xml（模块已注册）
