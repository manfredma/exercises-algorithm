package manfred.exercises.leetcode.p0328;

import java.util.Arrays;

/*
给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别分组，保持它们原有的相对顺序，然后把偶数索引节点分组连接到奇数索引节点分组之后，返回重新排序的链表。

第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。

请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。

你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。



示例 1:

输入: head = [1,2,3,4,5]
输出: [1,3,5,2,4]

示例 2:

输入: head = [2,1,3,5,6,4,7]
输出: [2,3,6,7,1,5,4]



提示:


n ==  链表中的节点数


0 <= n <= 10^4


-10^6 <= Node.val <= 10^6
*/
/** LeetCode 第 328 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 3, 5, 2, 4}, values(s.oddEvenList(list(1, 2, 3, 4, 5))));
        assertArrayEquals(
                new int[] {2, 3, 6, 7, 1, 5, 4}, values(s.oddEvenList(list(2, 1, 3, 5, 6, 4, 7))));
        assertArrayEquals(new int[] {}, values(s.oddEvenList(list())));
        assertArrayEquals(new int[] {1}, values(s.oddEvenList(list(1))));
    }

    private static ListNode list(int... a) {
        ListNode d = new ListNode(0), p = d;
        for (int x : a) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return d.next;
    }

    private static int[] values(ListNode h) {
        java.util.ArrayList<Integer> v = new java.util.ArrayList<Integer>();
        for (; h != null; h = h.next) v.add(h.val);
        int[] a = new int[v.size()];
        for (int i = 0; i < a.length; i++) a[i] = v.get(i);
        return a;
    }

    private static void assertArrayEquals(int[] e, int[] a) {
        if (!Arrays.equals(e, a))  {
            throw new AssertionError("expect: " + Arrays.toString(e) + ", actual: " + Arrays.toString(a));
        }
    }
}
