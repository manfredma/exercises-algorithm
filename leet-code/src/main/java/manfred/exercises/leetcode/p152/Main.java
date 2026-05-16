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
package manfred.exercises.leetcode.p152;

/**
 * LeetCode 第 152 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{0, 2}));
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
    }
}
