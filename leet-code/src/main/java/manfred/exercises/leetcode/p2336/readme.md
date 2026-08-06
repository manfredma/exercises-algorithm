# 无限集中的最小数字

现有一个包含所有正整数的集合 `[1, 2, 3, 4, 5, ...]`。实现 `SmallestInfiniteSet`：

- `popSmallest()`：移除并返回集合中的最小整数。
- `addBack(num)`：若正整数 `num` 不在集合中，将其添加回集合。

## 示例：

```text
输入：
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
输出：[null, null, 1, 2, 3, null, 1, 4, 5]
```

## 提示：

- `1 <= num <= 1000`
- 最多调用 `popSmallest` 和 `addBack` 共计 `1000` 次
