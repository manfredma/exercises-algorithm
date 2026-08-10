package manfred.exercises.leetcode.solved.p2101to2200.p2130;

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode reversedFirstHalf = null;
        ListNode fast = head;

        while (fast != null) {
            // 快指针跑两步（链表是偶数长度的，因此每次步进两次是安全的）
            fast = fast.next.next;
            // 保存前半段的下一个节点，避免反转时断链
            ListNode nextSlow = slow.next;

            // 反转前半段的当前节点
            slow.next = reversedFirstHalf;

            reversedFirstHalf = slow;
            slow = nextSlow;
        }

        // slow 指向后半段起点，reversedFirstHalf 指向反转后的前半段起点
        int result = 0;
        while (slow != null) {
            result = Math.max(result, slow.val + reversedFirstHalf.val);
            slow = slow.next;
            reversedFirstHalf = reversedFirstHalf.next;
        }
        return result;
    }
}
