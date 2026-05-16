package manfred.exercises.leetcode.p0092;

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
        return String.valueOf(val);
    }
}