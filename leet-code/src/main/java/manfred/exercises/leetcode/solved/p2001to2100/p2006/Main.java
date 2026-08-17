package manfred.exercises.leetcode.solved.p2001to2100.p2006;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/ */

/*
给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。

|x| 的值定义为：


如果 x >= 0 ，那么值为 x 。


如果 x < 0 ，那么值为 -x 。


示例 1：

输入：nums = [1,2,2,1], k = 1
输出：4
解释：差的绝对值为 1 的数对为：
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]

示例 2：

输入：nums = [1,3], k = 3
输出：0
解释：没有任何数对差的绝对值为 3 。

示例 3：

输入：nums = [3,2,1,5,4], k = 2
输出：3
解释：差的绝对值为 2 的数对为：
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]


提示：


1 <= nums.length <= 200


1 <= nums[i] <= 100


1 <= k <= 99
*/
/** LeetCode 第 2006 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertBothSolutions(solution, solution2, 4, new int[] {1, 2, 2, 1}, 1);
        assertBothSolutions(solution, solution2, 0, new int[] {1, 3}, 3);
        assertBothSolutions(solution, solution2, 3, new int[] {3, 2, 1, 5, 4}, 2);
        assertBothSolutions(solution, solution2, 0, new int[] {42}, 1);
        assertBothSolutions(solution, solution2, 0, new int[] {7, 7, 7}, 1);
        assertBothSolutions(solution, solution2, 1, new int[] {1, 100}, 99);
    }

    private static void assertBothSolutions(Solution solution, Solution2 solution2, int expected, int[] nums, int k) {
        assertEquals(expected, solution.countKDifference(nums, k));
        assertEquals(expected, solution2.countKDifference(nums, k));
    }

}
