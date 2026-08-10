# 咒语和药水的成功对数

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/)


给你两个正整数数组 `spells` 和 `potions`，长度分别为 `n` 和 `m`，其中 `spells[i]`
表示第 `i` 个咒语的能量强度，`potions[j]` 表示第 `j` 瓶药水的能量强度。

同时给你一个整数 `success`。一个咒语和药水的能量强度相乘如果大于等于 `success`，
那么它们视为一对成功的组合。

请你返回一个长度为 `n` 的整数数组 `pairs`，其中 `pairs[i]` 是能跟第 `i` 个咒语成功组合的药水数目。

## 示例 1：

```text
输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
输出：[4,0,3]
```

## 示例 2：

```text
输入：spells = [3,1,2], potions = [8,5,8], success = 16
输出：[2,0,2]
```

## 提示：

- `n == spells.length`
- `m == potions.length`
- `1 <= n, m <= 10^5`
- `1 <= spells[i], potions[i] <= 10^5`
- `1 <= success <= 10^10`
