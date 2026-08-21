package manfred.exercises.leetcode.solved.p0201to0300.p0237;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * <p>解法一：整段前移法。无法访问 head，只能就地改值——从 node 起把后续每个节点的值
 * 逐位前移一位（node←next←next.next←…），指针停在倒数第二个节点，最后断开末尾节点。
 * 效果上 node 原值被覆盖、后段整体前移、物理删除末尾节点，等效于「node 被删」。
 *
 * <p>关键点：循环条件 {@code node.next.next != null} 确保停在倒数第二个节点，
 * 出循环时 node.next 指向末尾节点，置 null 即断尾；题目保证 node 非末尾，故 node.next 必非 null。
 *
 * <p>对比 {@link Solution2}：本解法逐位前移整段，O(k)（k 为 node 到末尾距离，最坏 O(n)）；
 * Solution2 只移一个值跳一个节点，O(1)，更优。保留本解法展示「值覆盖」的朴素推导过程。
 *
 * <p>时间复杂度 O(k)，最坏 O(n)；空间复杂度 O(1)。
 */
class Solution {
    public void deleteNode(ListNode node) {
        // 从 node 起逐位前移，直到停在倒数第二个节点
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        // 把末尾节点的值搬到最后一个待填位置
        node.val = node.next.val;
        // 断开末尾节点，完成物理删除
        node.next = null;
    }
}
