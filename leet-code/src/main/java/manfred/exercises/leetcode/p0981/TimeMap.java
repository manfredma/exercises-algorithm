package manfred.exercises.leetcode.p0981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 第 981 题「基于时间的键值存储」。
 *
 * <p>设计一个基于时间的键值数据结构：
 * <ul>
 *   <li>{@code set(key, value, timestamp)}：存储某时间戳下的键值</li>
 *   <li>{@code get(key, timestamp)}：返回 timestamp_prev <= timestamp 中最大的那一个值</li>
 * </ul>
 * 注意：题目保证 set 的 timestamp 严格递增，因此每个 key 的记录天然有序，可直接追加、二分查找。
 */
class TimeMap {

    /** 单条记录：时间戳 + 值。用内部类替代 Object[]，获得类型安全，免去裸强转。 */
    private static final class Entry {
        final int timestamp;
        final String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Entry>> store = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
        // computeIfAbsent：key 不存在则懒建 list，存在则直接返回；因 timestamp 严格递增，直接追加末尾即可
        store.computeIfAbsent(key, k -> new ArrayList<>())
             .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = store.get(key);
        if (entries == null || entries.isEmpty()) {
            return "";
        }
        // 二分找右边界：最后一个 timestamp_prev <= timestamp 的记录
        int low = 0, high = entries.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midTimestamp = entries.get(mid).timestamp;
            if (timestamp == midTimestamp) {
                return entries.get(mid).value;
            } else if (timestamp > midTimestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // high < 0 表示所有记录的时间戳都大于查询值，无满足条件的记录
        return high >= 0 ? entries.get(high).value : "";
    }
}
