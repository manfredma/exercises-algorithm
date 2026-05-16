package manfred.exercises.leetcode.p0025;

/**
 * LeetCode 第 25 题「K 个一组翻转链表」（方案2）：按 K 个一组截取子链表逐段反转，递归或迭代。
 */
class Solution2 {
    ListNode pre = null;
    ListNode first = null;
    ListNode check = null;
    ListNode current = null;
    ListNode currentNext = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        if (1 == k) {
            return head;
        }

        ListNode v = new ListNode(0);
        v.next = head;
        pre = v;
        first = head;
        check = head;
        current = head;
        currentNext = current.next;
        for (int i = 1; null != check; i++) {
            check = check.next;
            if (i % k == 0) {
                // has k element
                for (int j = 1; j < k; j++) {
                    // del
                    current = currentNext;
                    if (null != currentNext) {
                        currentNext = currentNext.next;
                    }
                    first.next = current.next;

                    // add
                    current.next = pre.next;
                    pre.next = current;
                }
                if (null != currentNext)
                    currentNext = currentNext.next;
                pre = first;
                first = first.next;
            }

        }
        return v.next;
    }
}