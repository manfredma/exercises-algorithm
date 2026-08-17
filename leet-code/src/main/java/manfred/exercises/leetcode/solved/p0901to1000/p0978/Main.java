package manfred.exercises.leetcode.solved.p0901to1000.p0978;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/longest-turbulent-subarray/ */

/**
 * LeetCode 第 978 题（最长湍流子数组）的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: arr = [9,4,2,10,7,8,8,1,9] → 期望 5
        assertEquals(5, solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        // 示例 2: arr = [4,8,12,16] → 期望 2
        assertEquals(2, solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        // 示例 3: arr = [100] → 期望 1
        assertEquals(1, solution.maxTurbulenceSize(new int[]{100}));

        System.out.println("p0978 passed");
    }
}
