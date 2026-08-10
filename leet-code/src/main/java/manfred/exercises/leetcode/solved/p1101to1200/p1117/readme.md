# H2O 生成

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/building-h2o/)


现在有两种线程：氧 `oxygen` 和氢 `hydrogen`。目标是组织这些线程来产生水分子。

存在一个屏障，使得每个线程必须等候，直到一个完整水分子能够被产生。
氢和氧线程会分别获得 `releaseHydrogen` 和 `releaseOxygen` 方法，以允许它们突破屏障。

这些线程应三三成组突破屏障并立即组合产生一个水分子。必须保证一个水分子所需线程的结合发生在下一个水分子产生之前。

- 氧线程到达屏障时若没有氢线程，必须等候直到两个氢线程到达。
- 氢线程到达屏障时若没有其它线程，必须等候直到一个氧线程和另一个氢线程到达。

编写满足这些限制的氢、氧线程同步代码。

## 示例 1：

```text
输入：water = "HOH"
输出："HHO"
解释："HOH" 和 "OHH" 也都是有效解。
```

## 示例 2：

```text
输入：water = "OOHHHH"
输出："HHOHHO"
解释："HOHHHO"、"OHHHHO"、"HHOHOH"、"HOHHOH"、"OHHHOH"、
"HHOOHH"、"HOHOHH" 和 "OHHOHH" 也都是有效解。
```

## 提示：

- `3 * n == water.length`
- `1 <= n <= 20`
- `water[i] == 'O' or water[i] == 'H'`
- 输入字符串 `water` 中 `H` 的总数是 `2 * n`。
- 输入字符串 `water` 中 `O` 的总数是 `n`。
