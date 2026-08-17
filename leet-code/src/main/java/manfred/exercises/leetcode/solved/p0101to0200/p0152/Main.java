/*

Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0152;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-product-subarray/ */

/**
 * LeetCode 第 152 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [0, 2]: 子数组 [0]=0、[2]=2、[0,2]=0，最大乘积为 2（手算）
        assertEquals(2, solution.maxProduct(new int[]{0, 2}));
        // 题面示例 1
        assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
        // 题面示例 2
        assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println("p0152 passed");
    }
}
