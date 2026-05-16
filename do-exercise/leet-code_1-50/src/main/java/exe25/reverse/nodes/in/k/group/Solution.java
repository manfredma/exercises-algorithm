package exe25.reverse.nodes.in.k.group;

import java.util.Stack;

/**
 * LeetCode 第 25 题「K 个一组翻转链表」：按 K 个一组截取子链表逐段反转，递归或迭代。
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head || null == head.next) {
            return head;
        }
        if (1 == k) {
            return head;
        }

        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode current = head;
        ListNode next = head.next;
        ListNode pre = null;
        ListNode result = head;
        while(true) {
            listNodeStack.push(current);
            if (listNodeStack.size() == k) {
                for (int i = 0; i < k; i++) {
                    if (null == pre) {
                        result = listNodeStack.peek();
                    }
                    ListNode l = listNodeStack.pop();
                    if (null != pre) {
                        pre.next = l;
                    }
                    pre = l;
                }
                pre.next = next;
                current = next;
                if (null == current) {
                    break;
                }
                next = current.next;
            } else {
                current = current.next;
                if (null == current) {
                    break;
                }
                next = current.next;
            }

        }
        return result;
    }
}