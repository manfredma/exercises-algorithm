package manfred.exercises.leetcode.solved.p0401to0500.p0445;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.fail;

/** 题目链接：https://leetcode.cn/problems/add-two-numbers-ii/ */

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例1：

输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]

示例2：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]

示例3：

输入：l1 = [0], l2 = [0]
输出：[0]

提示：

    链表的长度范围为 [1, 100]
    0 <= node.val <= 9
    输入数据保证链表代表的数字无前导 0

进阶：如果输入链表不能翻转该如何解决？
*/
/**
 * LeetCode 第 445 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: l1 = [7,2,4,3], l2 = [5,6,4] → 期望 [7,8,0,7]
        assertListEquals(solution.addTwoNumbers(build(new int[]{7, 2, 4, 3}), build(new int[]{5, 6, 4})),
                new int[]{7, 8, 0, 7});
        // 示例 2: l1 = [2,4,3], l2 = [5,6,4] → 期望 [8,0,7]
        assertListEquals(solution.addTwoNumbers(build(new int[]{2, 4, 3}), build(new int[]{5, 6, 4})),
                new int[]{8, 0, 7});
        // 示例 3: l1 = [0], l2 = [0] → 期望 [0]
        assertListEquals(solution.addTwoNumbers(build(new int[]{0}), build(new int[]{0})),
                new int[]{0});
        System.out.println("p0445 passed");
    }

    /** 按数组顺序构造链表（高位在前）。 */
    private static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    /** 断言链表值序列等于期望数组。 */
    private static void assertListEquals(ListNode head, int[] expected) {
        ListNode cur = head;
        for (int v : expected) {
            if (cur == null) {
                fail("链表比期望短，期望 " + java.util.Arrays.toString(expected));
            }
            assertEquals(v, cur.val);
            cur = cur.next;
        }
        if (cur != null) {
            fail("链表比期望长，期望 " + java.util.Arrays.toString(expected));
        }
    }
}
