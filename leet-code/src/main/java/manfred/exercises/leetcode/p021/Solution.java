package manfred.exercises.leetcode.p021;

/**
 * LeetCode 第 21 题「合并两个有序链表」：双指针逐一比较两链表节点，递归或迭代合并。
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (true) {
            if (null != l1 && null != l2) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
//                    current.next = null;
                } else {
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
//                    current.next = null;
                }
            } else if (null != l1) {
                current.next = l1;
                break;
            } else {
                current.next = l2;
                break;
            }
        }

        return head.next;
    }
}