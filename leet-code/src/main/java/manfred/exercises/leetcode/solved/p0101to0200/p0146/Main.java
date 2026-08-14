package manfred.exercises.leetcode.solved.p0101to0200.p0146;

/** 题目链接：https://leetcode.cn/problems/lru-cache/ */

/*
请你设计并实现一个满足 LRU (最近最少使用) 缓存约束的数据结构。
- LRUCache(int capacity)
- int get(int key)
- void put(int key, int value)

示例操作序列：
["LRUCache","put","put","get","put","get","put","get","get","get"]
[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
输出：[null,null,null,1,null,-1,null,-1,3,4]
*/
/**
 * LeetCode 第 146 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例：容量 2 的标准用例
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);                   // 缓存 {1=1}
        cache.put(2, 2);                   // 缓存 {1=1, 2=2}
        assertEquals(1, cache.get(1));     // 命中 1，1 变为最近使用
        cache.put(3, 3);                   // 逐出最久未使用的 2，缓存 {1=1, 3=3}
        assertEquals(-1, cache.get(2));    // 2 已被逐出
        cache.put(4, 4);                   // 逐出最久未使用的 1，缓存 {4=4, 3=3}
        assertEquals(-1, cache.get(1));    // 1 已被逐出
        assertEquals(3, cache.get(3));     // 命中 3
        assertEquals(4, cache.get(4));     // 命中 4

        // 重刷：LRUCache2 走相同操作序列
        LRUCache2 cache2 = new LRUCache2(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        assertEquals(1, cache2.get(1));
        cache2.put(3, 3);
        assertEquals(-1, cache2.get(2));
        cache2.put(4, 4);
        assertEquals(-1, cache2.get(1));
        assertEquals(3, cache2.get(3));
        assertEquals(4, cache2.get(4));

        // LinkedHashMap：LRUCache3 走相同操作序列
        LRUCache3 cache3 = new LRUCache3(2);
        cache3.put(1, 1);
        cache3.put(2, 2);
        assertEquals(1, cache3.get(1));
        cache3.put(3, 3);
        assertEquals(-1, cache3.get(2));
        cache3.put(4, 4);
        assertEquals(-1, cache3.get(1));
        assertEquals(3, cache3.get(3));
        assertEquals(4, cache3.get(4));

        // 边界: put 更新已存在的 key 不触发逐出
        LRUCache cache3a = new LRUCache(2);
        cache3a.put(1, 1);
        cache3a.put(2, 2);
        cache3a.put(1, 10);                // 更新 1，不逐出 2
        assertEquals(10, cache3a.get(1));  // 值已更新
        assertEquals(2, cache3a.get(2));   // 2 仍在

        LRUCache2 cache3b = new LRUCache2(2);
        cache3b.put(1, 1);
        cache3b.put(2, 2);
        cache3b.put(1, 10);
        assertEquals(10, cache3b.get(1));
        assertEquals(2, cache3b.get(2));

        LRUCache3 cache3c = new LRUCache3(2);
        cache3c.put(1, 1);
        cache3c.put(2, 2);
        cache3c.put(1, 10);
        assertEquals(10, cache3c.get(1));
        assertEquals(2, cache3c.get(2));

        // 边界: 容量 1
        LRUCache cache4a = new LRUCache(1);
        cache4a.put(1, 1);
        assertEquals(1, cache4a.get(1));
        cache4a.put(2, 2);                 // 逐出 1
        assertEquals(-1, cache4a.get(1));
        assertEquals(2, cache4a.get(2));

        LRUCache2 cache4b = new LRUCache2(1);
        cache4b.put(1, 1);
        assertEquals(1, cache4b.get(1));
        cache4b.put(2, 2);
        assertEquals(-1, cache4b.get(1));
        assertEquals(2, cache4b.get(2));

        LRUCache3 cache4c = new LRUCache3(1);
        cache4c.put(1, 1);
        assertEquals(1, cache4c.get(1));
        cache4c.put(2, 2);
        assertEquals(-1, cache4c.get(1));
        assertEquals(2, cache4c.get(2));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
