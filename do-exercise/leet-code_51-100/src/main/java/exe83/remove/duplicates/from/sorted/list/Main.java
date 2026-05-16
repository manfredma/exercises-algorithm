/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */
package exe83.remove.duplicates.from.sorted.list;

/**
 * LeetCode 第 83 题「删除排序链表中的重复元素」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Solution solution = new Solution();
        solution.deleteDuplicates(l1);

        ListNode cu = l1;
        while (null != cu) {
            System.out.print(cu.val + " -> ");
            cu = cu.next;
        }
    }
}
