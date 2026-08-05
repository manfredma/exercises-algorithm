# 按权重随机选择

给你一个下标从 `0` 开始的正整数数组 `w`，其中 `w[i]` 代表第 `i` 个下标的权重。

请你实现函数 `pickIndex`，它可以从范围 `[0, w.length - 1]` 内随机选出并返回一个下标。
选取下标 `i` 的概率为 `w[i] / sum(w)`。

例如，对于 `w = [1, 3]`，挑选下标 `0` 的概率为 `0.25`，选取下标 `1` 的概率为 `0.75`。

## 示例 1：

```text
输入：
["Solution","pickIndex"]
[[[1]],[]]
输出：
[null,0]
解释：
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
```

## 示例 2：

```text
输入：
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
输出：
[null,1,1,1,1,0]
```

由于这是一个随机问题，允许多个答案。

## 提示：

- `1 <= w.length <= 10^4`
- `1 <= w[i] <= 10^5`
- `pickIndex` 将被调用不超过 `10^4` 次
