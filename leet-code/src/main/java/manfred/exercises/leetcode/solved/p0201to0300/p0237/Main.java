package manfred.exercises.leetcode.solved.p0201to0300.p0237;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 0237 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        // 示例 1: head = [4,5,1,9], node = 5 → [4,1,9]
        ListNode head1a = buildList(new int[]{4, 5, 1, 9});
        solution.deleteNode(findNode(head1a, 5));
        assertEquals(new int[]{4, 1, 9}, toValues(head1a), "head=[4,5,1,9], node=5");
        ListNode head1b = buildList(new int[]{4, 5, 1, 9});
        solution2.deleteNode(findNode(head1b, 5));
        assertEquals(new int[]{4, 1, 9}, toValues(head1b), "Solution2 head=[4,5,1,9], node=5");

        // 示例 2: head = [4,5,1,9], node = 1 → [4,5,9]
        ListNode head2a = buildList(new int[]{4, 5, 1, 9});
        solution.deleteNode(findNode(head2a, 1));
        assertEquals(new int[]{4, 5, 9}, toValues(head2a), "head=[4,5,1,9], node=1");
        ListNode head2b = buildList(new int[]{4, 5, 1, 9});
        solution2.deleteNode(findNode(head2b, 1));
        assertEquals(new int[]{4, 5, 9}, toValues(head2b), "Solution2 head=[4,5,1,9], node=1");

        // 边界: 两节点链表删除首节点 head=[1,2], node=1 → [2]
        ListNode head3a = buildList(new int[]{1, 2});
        solution.deleteNode(findNode(head3a, 1));
        assertEquals(new int[]{2}, toValues(head3a), "head=[1,2], node=1");
        ListNode head3b = buildList(new int[]{1, 2});
        solution2.deleteNode(findNode(head3b, 1));
        assertEquals(new int[]{2}, toValues(head3b), "Solution2 head=[1,2], node=1");

        // 边界: 含负值的中间节点删除 head=[-3,5,-99,0,7], node=-99 → [-3,5,0,7]
        ListNode head4a = buildList(new int[]{-3, 5, -99, 0, 7});
        solution.deleteNode(findNode(head4a, -99));
        assertEquals(new int[]{-3, 5, 0, 7}, toValues(head4a), "head=[-3,5,-99,0,7], node=-99");
        ListNode head4b = buildList(new int[]{-3, 5, -99, 0, 7});
        solution2.deleteNode(findNode(head4b, -99));
        assertEquals(new int[]{-3, 5, 0, 7}, toValues(head4b), "Solution2 head=[-3,5,-99,0,7], node=-99");

        System.out.println("leet#0237 passed");
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : values) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private static ListNode findNode(ListNode head, int val) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == val) {
                return cur;
            }
        }
        throw new IllegalArgumentException("value not found: " + val);
    }

    private static int[] toValues(ListNode head) {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        int[] arr = new int[size];
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            arr[i++] = cur.val;
        }
        return arr;
    }
}
