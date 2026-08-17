package manfred.exercises.leetcode.solved.p0201to0300.p0220;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/contains-duplicate-iii/ */

/**
 * LeetCode 第 220 题「存在重复元素 III」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Input: nums = [1,2,3,1], k = 3, t = 0
         * Output: true
         * Example 2:
         *
         * Input: nums = [1,0,1,1], k = 1, t = 2
         * Output: true
         * Example 3:
         *
         * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
         * Output: false
         *
         * [2147483640,2147483641] 1 100
         * [2147483647,-1,2147483647] 1 2147483647
         */
        Solution solution = new Solution();
        // 边界用例: 溢出场景, |2147483647-(-1)|=2147483648 > t=2147483647 → 期望 false
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{2147483647,-1,2147483647}, 1, 2147483647));
        // 边界用例: diff=1 ≤ t=100, 索引差=1 ≤ k=1 → 期望 true
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100));
        // 示例 1: nums=[1,2,3,1], k=3, t=0 → 期望 true
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        // 示例 2: nums=[1,0,1,1], k=1, t=2 → 期望 true
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        // 示例 3: nums=[1,5,9,1,5,9], k=2, t=3 → 期望 false
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println("p0220 passed");
    }
}
