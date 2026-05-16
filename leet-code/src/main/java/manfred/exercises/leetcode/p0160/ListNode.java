package manfred.exercises.leetcode.p0160;

/**
 * 链表节点定义。
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}