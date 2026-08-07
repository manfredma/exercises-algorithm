package manfred.exercises.leetcode.solved.p0401to0500.p0435;
/* 返回移除的最少区间数，使剩余区间不重叠；端点相接不算重叠。
示例输出依次为：1、2、0。 */

/**
 * LeetCode 第 435 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        assertEquals(2, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError();
    }
}
