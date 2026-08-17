# 直线上最多的点数

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/max-points-on-a-line/)

给你一个数组 points ，其中 points[i] = [xᵢ, yᵢ] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。

## 示例 1

```text
输入：points = [[1,1],[2,2],[3,3]]
输出：3
```

## 示例 2

```text
输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出：4
```

## 提示

- 1 <= points.length <= 300
- points[i].length == 2
- -10^4 <= xᵢ, yᵢ <= 10^4
- points 中的所有点 互不相同
