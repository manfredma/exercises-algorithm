package manfred.exercises.leetcode.solved.p0101to0200.p0146;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 缓存 —— HashMap + 双向链表（核心实现）。
 *
 * <p>思路：HashMap 存 key→Node 映射实现 O(1) 查找，双向链表维护「最近使用顺序」
 * （head 端为最近使用，tail 端为最久未使用）。get 命中后把节点移到 head 端；
 * put 时若 key 已存在则先摘除旧节点，再头插新值；容量超限时摘除 tail 端节点并从 map 删除。
 *
 * <p>复杂度：get / put 均摊 O(1)；空间 O(capacity)。
 */
class LRUCache {

    private final ListNode head = new ListNode(-1, -1);
    private final ListNode tail = new ListNode(-1, -1);
    private final int capacity;
    private final Map<Integer, ListNode> indexMap;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        indexMap = new HashMap<>(capacity);
        this.size = 0;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!indexMap.containsKey(key)) {
            return -1;
        }

        ListNode cur = indexMap.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;

        cur.next = head.next;
        head.next.pre = cur;

        cur.pre = head;
        head.next = cur;

        return cur.val;
    }

    public void put(int key, int value) {
        if (indexMap.containsKey(key)) {
            ListNode old = indexMap.get(key);
            old.pre.next = old.next;
            old.next.pre = old.pre;
            indexMap.remove(key);
            size--;
        }
        // 处理集合满的情况
        if (size == capacity) {
            size--;
            ListNode preTail = tail.pre;
            indexMap.remove(preTail.key);

            tail.pre = preTail.pre;
            preTail.pre.next = tail;

            preTail.next = null;
            preTail.pre = null;
        }
        size++;
        ListNode cur = new ListNode(key, value);
        cur.next = head.next;
        head.next.pre = cur;

        head.next = cur;
        cur.pre = head;

        indexMap.put(key, cur);
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