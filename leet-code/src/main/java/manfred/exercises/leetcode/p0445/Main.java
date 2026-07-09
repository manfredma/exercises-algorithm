package manfred.exercises.leetcode.p0445;

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
        ListNode l1 = build(new int[]{7, 2, 4, 3});
        ListNode l2 = build(new int[]{5, 6, 4});
        print(solution.addTwoNumbers(l1, l2));
        // 示例 2: l1 = [2,4,3], l2 = [5,6,4] → 期望 [8,0,7]
        print(solution.addTwoNumbers(build(new int[]{2, 4, 3}), build(new int[]{5, 6, 4})));
        // 示例 3: l1 = [0], l2 = [0] → 期望 [0]
        print(solution.addTwoNumbers(build(new int[]{0}), build(new int[]{0})));
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

    /** 打印链表，如 [7,8,0,7]。 */
    private static void print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append(cur.val);
        }
        sb.append("]");
        System.out.println(sb);
    }
}
