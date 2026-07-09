package manfred.exercises.leetcode.p0445;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 链表高位在前、低位在后，相加需从低位向高位计算（进位向上传播）。
        // 用两个栈把两条链表的值压入，pop 时即从低位到高位处理，避免翻转链表。
        Deque<Integer> digits1 = pushDigits(l1);
        Deque<Integer> digits2 = pushDigits(l2);

        // 哨兵节点：结果用头插法构造，先算出的低位插在头部，最终高位自然在前，无需二次翻转。
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (!digits1.isEmpty() || !digits2.isEmpty()) {
            int sum = popDigit(digits1) + popDigit(digits2) + carry;
            carry = sum / 10;
            int digit = sum % 10;
            dummy.next = new ListNode(digit, dummy.next);
        }

        // 最高位若仍有进位，头插到结果最前。
        if (carry > 0) {
            dummy.next = new ListNode(carry, dummy.next);
        }
        return dummy.next;
    }

    /** 将链表各节点值按原顺序压栈，返回后进先出的数字栈（pop 即从低位到高位）。 */
    private Deque<Integer> pushDigits(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            stack.push(cur.val);
        }
        return stack;
    }

    /** 从栈中弹出一个数字位，栈空时返回 0（对齐较短的链表）。 */
    private int popDigit(Deque<Integer> stack) {
        return stack.isEmpty() ? 0 : stack.pop();
    }
}
