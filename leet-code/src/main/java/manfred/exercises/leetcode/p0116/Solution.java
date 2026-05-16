package manfred.exercises.leetcode.p0116;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
 * LeetCode 第116题 填充每个节点的下一个右侧节点指针，利用完美二叉树性质递归连接同层相邻节点。
 */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            Node l = root.left;
            Node r = root.right;
            while (l.right != null) {
                l.right.next = r.left;
                l = l.right;
                r = r.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }
}