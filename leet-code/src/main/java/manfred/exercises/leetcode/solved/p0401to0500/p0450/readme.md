# 删除二叉搜索树中的节点

> 题目链接：[LeetCode 中文站](https://leetcode.cn/problems/delete-node-in-a-bst/)


删除 BST 中值为 `key` 的节点，并保持 BST 性质，返回更新后的根节点。

![](images/del_node_1.jpg)
![](images/del_node_supp.jpg)

## 示例

```text
root = [5,3,6,2,4,null,7], key = 3 -> [5,4,6,2,null,null,7]（其他合法 BST 也可）
root = [5,3,6,2,4,null,7], key = 0 -> 原树
root = [], key = 0 -> []
```

## 提示

- 节点数范围为 `[0, 10^4]`
- 节点值唯一，`root` 是合法 BST
