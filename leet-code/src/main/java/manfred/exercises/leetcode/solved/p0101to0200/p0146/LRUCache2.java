package manfred.exercises.leetcode.solved.p0101to0200.p0146;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存 —— HashMap + 双向链表（重刷实现）。
 *
 * <p>思路：与 {@link LRUCache} 同为 HashMap + 双向链表，区别在 put 的写法：
 * 先无条件 insertFirst 新节点，再用 cache.put 的返回值判断——返回非空说明是更新，
 * 删除返回的旧节点；返回 null 说明是新增，按容量逐出 tail 端。get 命中后 removeNode + insertFirst 移到头部。
 *
 * <p>复杂度：get / put 均摊 O(1)；空间 O(capacity)。
 */
class LRUCache2 {

    private ListNode head = new ListNode(-1, -1);
    private ListNode tail = new ListNode(-1, -1);
    private Map<Integer, ListNode> cache = new HashMap<>();
    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 处理链表，将该元素放到头部
        removeNode(node);

        insertFirst(node);
        return node.val;
    }

    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode(key, value);
        // 加入到链表的头部
        insertFirst(node);
        ListNode old = cache.put(key, node);
        if (old != null) {
            // 说明之前是存在值的，因此需要删除 old 即可
            removeNode(old);
        } else if (cache.size() > capacity) {
            // 移走末尾的元素
            ListNode remove = tail.pre;
            removeNode(remove);
            // 移走 Map 中的缓存
            cache.remove(remove.key);
        }
    }

    private void insertFirst(ListNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        node.pre.next = node;
    }

    private static class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode pre;

        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
}
