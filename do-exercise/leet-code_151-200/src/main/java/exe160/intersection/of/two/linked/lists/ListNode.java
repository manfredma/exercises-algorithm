package exe160.intersection.of.two.linked.lists;

/**
 * 链表节点定义。
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}