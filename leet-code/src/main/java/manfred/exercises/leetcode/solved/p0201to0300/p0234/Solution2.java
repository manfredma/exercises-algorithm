package manfred.exercises.leetcode.solved.p0201to0300.p0234;

/**
 * 回文链表 —— 快慢指针 + 边走边反转前半段（O(n) 时间 O(1) 空间）。
 *
 * <p>思路：快慢指针找中点的同时，反转 slow 经过的前半段（pre 链从 null 开始）。
 * 快指针到尾时，slow 恰在中点；奇数长度跳过中间节点；随后 pre（前半段反转）
 * 与 slow（后半段）逐节点比较。
 *
 * <p>反转前半段只需 pre、next 两个临时变量：next 保存 slow.next 防止断链，
 * pre 累积反转后的头。相比反转后半段（需 pre/next/tmp 三个变量）更简洁。
 *
 * <p>复杂度：时间 O(n)，空间 O(1)。注意会修改原链表前半段结构（题目不要求恢复）。
 */
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 找到中心节点并反转前半部分链表
        ListNode pre = null;
        ListNode next = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 在修改 slow 之前先反转当前 slow
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }


        if (fast != null) {
            // 如果是奇数个节点，则当前正好在中间，对于判断回文串没有用，因此需要跳过这个中间节点
            slow = slow.next;
        }


        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }
}
