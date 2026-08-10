# 找出两数组的不同

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/find-the-difference-of-two-arrays/)


给你两个下标从 `0` 开始的整数数组 `nums1` 和 `nums2`，返回长度为 `2` 的列表 `answer`。
`answer[0]` 是 `nums1` 中不存在于 `nums2` 中的不同整数；`answer[1]` 反之。整数可以按任意顺序返回。

## 示例 1：

```text
输入：nums1 = [1,2,3], nums2 = [2,4,6]
输出：[[1,3],[4,6]]
```

## 示例 2：

```text
输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
输出：[[3],[]]
```

## 提示：

- `1 <= nums1.length, nums2.length <= 1000`
- `-1000 <= nums1[i], nums2[i] <= 1000`
