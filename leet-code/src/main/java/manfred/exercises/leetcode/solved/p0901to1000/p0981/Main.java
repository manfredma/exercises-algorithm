package manfred.exercises.leetcode.solved.p0901to1000.p0981;

import static manfred.exercises.assertion.Assert.assertArrayEquals;

/*
设计一个基于时间的键值数据结构 TimeMap：
- set(key, value, timestamp)：存储某时间戳下的键值
- get(key, timestamp)：返回 timestamp_prev <= timestamp 中最大的那一个值；无则返回 ""

示例 1:
输入：["TimeMap","set","get","get","set","get","get"]
     [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
输出：[null,null,"bar","bar",null,"bar2","bar2"]

提示：set 的 timestamp 严格递增；最多调用 2*10^5 次。
*/
/**
 * LeetCode 第 981 题的测试入口。
 *
 * <p>按示例 1 的调用序列驱动 TimeMap，断言 get 结果。
 */
public class Main {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        // 按 LeetCode 操作序列执行，收集输出
        Object[] outputs = new Object[7];
        outputs[0] = null;
        timeMap.set("foo", "bar", 1);   outputs[1] = null;
        outputs[2] = timeMap.get("foo", 1);   // 期望 "bar"
        outputs[3] = timeMap.get("foo", 3);   // 期望 "bar"
        timeMap.set("foo", "bar2", 4);  outputs[4] = null;
        outputs[5] = timeMap.get("foo", 4);   // 期望 "bar2"
        outputs[6] = timeMap.get("foo", 5);   // 期望 "bar2"

        // 期望：[null, null, "bar", "bar", null, "bar2", "bar2"]
        assertArrayEquals(new Object[]{null, null, "bar", "bar", null, "bar2", "bar2"}, outputs);

        System.out.println("p0981 passed");
    }
}
