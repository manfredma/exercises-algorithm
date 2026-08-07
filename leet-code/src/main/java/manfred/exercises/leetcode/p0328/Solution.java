package manfred.exercises.leetcode.p0328;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode oddTail = cur;
        cur = cur.next;

        ListNode evenHead = cur;
        ListNode evenTail = cur;
        cur = cur.next;

        boolean isOdd = true;
        while (cur != null) {
            if (isOdd) {
                oddTail.next = cur;
                oddTail = oddTail.next;
            } else {
                evenTail.next = cur;
                evenTail = evenTail.next;
            }
            cur = cur.next;
            isOdd = !isOdd;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return head;
    }
}
