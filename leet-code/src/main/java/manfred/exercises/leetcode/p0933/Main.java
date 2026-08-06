package manfred.exercises.leetcode.p0933;

/*
写一个 RecentCounter 类来计算特定时间范围内最近的请求。
RecentCounter() 初始化计数器；ping(t) 添加时间 t 的请求，并返回 [t-3000, t] 内的请求数。
保证每次调用 ping 的 t 都严格递增。

示例：
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
输出：[null, 1, 2, 3, 3]。

提示：1 <= t <= 10^9；至多调用 ping 方法 10^4 次。
*/
/** LeetCode 第 933 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        assertEquals(1, recentCounter.ping(1));
        assertEquals(2, recentCounter.ping(100));
        assertEquals(3, recentCounter.ping(3001));
        assertEquals(3, recentCounter.ping(3002));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
