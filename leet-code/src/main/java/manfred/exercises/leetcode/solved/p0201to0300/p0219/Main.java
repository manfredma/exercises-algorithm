package manfred.exercises.leetcode.solved.p0201to0300.p0219;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/contains-duplicate-ii/ */

/**
 * LeetCode 第 219 题「存在重复元素 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Example 1:
         * <p>
         * Input: nums = [1,2,3,1], k = 3
         * Output: true
         * Example 2:
         * <p>
         * Input: nums = [1,0,1,1], k = 1
         * Output: true
         * Example 3:
         * <p>
         * Input: nums = [1,2,3,1,2,3], k = 2
         * Output: false
         */
        Solution solution = new Solution();
        // 示例 1: nums = [1,2,3,1], k = 3 → true
        assertTrue(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        // 示例 2: nums = [1,0,1,1], k = 1 → true
        assertTrue(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        // 示例 3: nums = [1,2,3,1,2,3], k = 2 → false
        assertFalse(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println("p0219 passed");
    }
}
