package manfred.exercises.leetcode.p0445;

/**
 * LeetCode 第 445 题的辅助数据结构。
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
