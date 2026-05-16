package exe116.populating.next.right.pointers.in.each.node;

/**
 * LeetCode 第 116 题「填充每个节点的下一个右侧节点指针」的核心数据结构实现。
 */
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