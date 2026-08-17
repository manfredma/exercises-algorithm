package manfred.exercises.leetcode.solved.p0201to0300.p0215;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/ */

/**
 * LeetCode 第 215 题「数组中的第 K 个最大元素」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
         * <p>
         * Input: nums = [3,2,1,5,6,4], k = 2
         * Output: 5
         * Example 2:
         * <p>
         * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
         * Output: 4
         */
        Solution solution = new Solution();
        // 示例 1: nums = [3,2,1,5,6,4], k = 2 → 期望 5
        assertEquals(5, solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // 示例 2: nums = [3,2,3,1,2,4,5,5,6], k = 4 → 期望 4
        assertEquals(4, solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println("p0215 passed");
    }
}
