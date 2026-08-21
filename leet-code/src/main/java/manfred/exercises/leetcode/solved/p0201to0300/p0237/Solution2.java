package manfred.exercises.leetcode.solved.p0201to0300.p0237;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * <p>解法二：值覆盖法（最优）。无法访问 head，故把后继的值搬到 node，再让 node.next
 * 跳过后继——node 原值被后继值替换、后继被移除，从链表视角看等效于「node 被删」。
 *
 * <p>关键点：只移一个值、跳一个节点；题目保证 node 非末尾，故 node.next 必非 null，无 NPE 风险。
 *
 * <p>对比 {@link Solution}：Solution 逐位前移整段后删末尾，O(k)；本解法 O(1)，是最优写法。
 *
 * <p>时间复杂度 O(1)，空间复杂度 O(1)。
 */
class Solution2 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
