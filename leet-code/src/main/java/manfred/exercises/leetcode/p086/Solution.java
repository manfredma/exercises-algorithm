package manfred.exercises.leetcode.p086;

/**
 * LeetCode 第 86 题「分隔链表」：创建两个虚拟头节点分别收集小于和大于等于 x 的节点。
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(x - 1);
        ListNode lessHead = less;
        ListNode more = new ListNode(x + 1);
        ListNode moreHead = more;

        ListNode current = head;
        while (null != current) {
            if (current.val < x) {
                less.next = current;
                less = less.next;
            } else {
                more.next = current;
                more = more.next;
            }
            current = current.next;
        }
        more.next = null;
        if (less != lessHead) {
            less.next = moreHead.next;
            return lessHead.next;
        } else {
            return moreHead.next;
        }
    }
}