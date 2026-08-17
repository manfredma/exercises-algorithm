package manfred.exercises.leetcode.solved.p0201to0300.p0234;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/palindrome-linked-list/ */

/*
给你一个单链表的头节点 head，请你判断该链表是否为回文链表。如果是，返回 true；否则，返回 false。

示例 1：

输入：head = [1,2,2,1]
输出：true

示例 2：

输入：head = [1,2]
输出：false
*/
/**
 * LeetCode 第 234 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        // 示例 1: head = [1,2,2,1] → 期望 true
        assertEquals(true, solution.isPalindrome(build(new int[]{1, 2, 2, 1})));
        assertEquals(true, solution2.isPalindrome(build(new int[]{1, 2, 2, 1})));
        // 示例 2: head = [1,2] → 期望 false
        assertEquals(false, solution.isPalindrome(build(new int[]{1, 2})));
        assertEquals(false, solution2.isPalindrome(build(new int[]{1, 2})));
        // 边界: 单节点 → 期望 true
        assertEquals(true, solution.isPalindrome(build(new int[]{1})));
        assertEquals(true, solution2.isPalindrome(build(new int[]{1})));
        // 边界: 奇数长度回文 → 期望 true
        assertEquals(true, solution.isPalindrome(build(new int[]{1, 2, 1})));
        assertEquals(true, solution2.isPalindrome(build(new int[]{1, 2, 1})));
        // 边界: 全相同 → 期望 true
        assertEquals(true, solution.isPalindrome(build(new int[]{5, 5, 5, 5})));
        assertEquals(true, solution2.isPalindrome(build(new int[]{5, 5, 5, 5})));
    }

    /** 按数组顺序构建单链表。 */
    private static ListNode build(int[] values) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

}
