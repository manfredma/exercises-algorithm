package manfred.exercises.leetcode.solved.p3001to3100.p3096;

import static manfred.exercises.assertion.Assert.assertEquals;

/**
 * LeetCode 第 3096 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/minimum-levels-to-gain-more-points/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 官方示例
        assertEquals(1, solution.minimumLevels(new int[]{1, 0, 1, 0}), "example 1");
        assertEquals(3, solution.minimumLevels(new int[]{1, 1, 1, 1, 1}), "example 2");
        assertEquals(-1, solution.minimumLevels(new int[]{0, 0}), "example 3");
        assertEquals(1, solution.minimumLevels(new int[]{0, 0, 0}), "example 4");

        // 边界：两名玩家各至少完成一个关卡，以及 Alice 立即领先的场景。
        assertEquals(1, solution.minimumLevels(new int[]{1, 0}), "two levels, Alice leads immediately");
        assertEquals(-1, solution.minimumLevels(new int[]{1, 1}), "two levels, tied scores");
        assertEquals(-1, solution.minimumLevels(new int[]{0, 1}), "two levels, Alice trails");
        assertEquals(1, solution.minimumLevels(new int[]{1, 0, 0}), "single-level prefix wins");
        System.out.println("leet#3096 passed");
    }
}
