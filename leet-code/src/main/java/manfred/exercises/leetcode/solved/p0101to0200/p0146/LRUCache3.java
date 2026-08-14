package manfred.exercises.leetcode.solved.p0101to0200.p0146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 缓存 —— LinkedHashMap 一行解法（标准库实现）。
 *
 * <p>思路：构造 {@code LinkedHashMap(capacity, 0.75f, accessOrder=true)}，第三个参数为 true
 * 使 get/put 命中的节点自动移到链表尾部（尾=最近使用，头=最久未使用）。
 * 重写 {@code removeEldestEntry} 在 {@code size() > capacity} 时返回 true，
 * JDK 在 put 后自动逐出链表头部（最久未使用）节点。
 *
 * <p>复杂度：get / put 均摊 O(1)；空间 O(capacity)。
 * 比 {@link LRUCache}/{@link LRUCache2} 手撕双向链表简洁得多，但依赖 JDK 内部实现，
 * 面试通常要求先手撕再提此解法。
 */
class LRUCache3 {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
