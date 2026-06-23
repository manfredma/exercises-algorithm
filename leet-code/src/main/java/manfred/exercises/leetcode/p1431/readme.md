# 拥有最多糖果的孩子

有 `n` 个有糖果的孩子。给你一个数组 `candies`，其中 `candies[i]` 代表第 `i` 个孩子拥有的糖果数目，和一个整数 `extraCandies` 表示你所有的额外糖果的数量。

返回一个长度为 `n` 的布尔数组 `result`，如果把所有的 `extraCandies` 给第 `i` 个孩子之后，他会拥有所有孩子中**最多**的糖果，那么 `result[i]` 为 `true`，否则为 `false`。

> 注意，允许有多个孩子同时拥有最多的糖果数目。

## 示例 1：

```
输入：candies = [2,3,5,1,3], extraCandies = 3
输出：[true,true,true,false,true]
解释：
- 孩子 1：2+3=5，是最多的 → true
- 孩子 2：3+3=6，是最多的 → true
- 孩子 3：5+3=8，是最多的 → true
- 孩子 4：1+3=4，不是最多的 → false
- 孩子 5：3+3=6，是最多的 → true
```

## 示例 2：

```
输入：candies = [4,2,1,1,2], extraCandies = 1
输出：[true,false,false,false,false]
```

## 示例 3：

```
输入：candies = [12,1,12], extraCandies = 10
输出：[true,false,true]
```

## 提示：

- `n == candies.length`
- `2 <= n <= 100`
- `1 <= candies[i] <= 100`
- `1 <= extraCandies <= 50`
