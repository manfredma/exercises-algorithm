package manfred.exercises.leetcode.solved.p3101to3200.p3105;

import static manfred.exercises.assertion.Assert.assertEquals;

/**
 * LeetCode 第 3105 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        // 示例 1：nums = [1,4,3,3,2] → 2（最长 [1,4] 递增或 [4,3]/[3,2] 递减，均长 2）
        assertEquals(2, solution.longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}),
                "nums=[1,4,3,3,2]");
        assertEquals(2, solution2.longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}),
                "Solution2 nums=[1,4,3,3,2]");

        // 示例 2：nums = [3,3,3,3] → 1（相邻相等，既不严格递增也不严格递减）
        assertEquals(1, solution.longestMonotonicSubarray(new int[]{3, 3, 3, 3}),
                "nums=[3,3,3,3]");
        assertEquals(1, solution2.longestMonotonicSubarray(new int[]{3, 3, 3, 3}),
                "Solution2 nums=[3,3,3,3]");

        // 示例 3：nums = [3,2,1] → 3（整段严格递减）
        assertEquals(3, solution.longestMonotonicSubarray(new int[]{3, 2, 1}),
                "nums=[3,2,1]");
        assertEquals(3, solution2.longestMonotonicSubarray(new int[]{3, 2, 1}),
                "Solution2 nums=[3,2,1]");

        // 边界·单元素：长度 1
        assertEquals(1, solution.longestMonotonicSubarray(new int[]{5}),
                "nums=[5]");
        assertEquals(1, solution2.longestMonotonicSubarray(new int[]{5}),
                "Solution2 nums=[5]");

        // 边界·整段严格递增
        assertEquals(5, solution.longestMonotonicSubarray(new int[]{1, 2, 3, 4, 5}),
                "nums=[1,2,3,4,5]");
        assertEquals(5, solution2.longestMonotonicSubarray(new int[]{1, 2, 3, 4, 5}),
                "Solution2 nums=[1,2,3,4,5]");

        // 边界·增减交替（每段长 2）
        assertEquals(2, solution.longestMonotonicSubarray(new int[]{1, 2, 1, 2, 1}),
                "nums=[1,2,1,2,1]");
        assertEquals(2, solution2.longestMonotonicSubarray(new int[]{1, 2, 1, 2, 1}),
                "Solution2 nums=[1,2,1,2,1]");

        System.out.println("leet#3105 passed");
    }
}
