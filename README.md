# exercises-algorithm

算法与数据结构练习项目，Java 8，Maven 多模块结构。

## 项目结构

| 模块 | 内容 |
|------|------|
| `leet-code_1-50` ~ `leet-code_1351-1400` | LeetCode 练习题，按题号段分模块 |
| `CTCI-01` | 《Cracking the Coding Interview》第1章面试题 |
| `common-algorithm` | 常用算法：排序（冒泡/插入/归并/快排/TimSort）、字符串匹配（BF/RK/BM/KMP）、动态规划、最短路径 |
| `data-structure` | 数据结构：堆排序、二叉搜索树、红黑树、图（邻接表/邻接矩阵） |
| `leet-code-grap` | LeetCode 图算法专题 |
| `data` | 文件读写工具类练习 |

## 快速开始

```bash
# 编译所有模块
mvn clean compile -DskipTests -Dsort.skip=true

# 编译单个模块
mvn clean compile -pl leet-code_1-50 -Dsort.skip=true
```

## 包名规范

- LeetCode：`manfred.exercises.leetcode.p001`（题号3位补零）
- CTCI：`manfred.exercises.ctci.c01`
- 算法：`manfred.exercises.algorithm.*`
- 数据结构：`manfred.exercises.datastructure.*`
