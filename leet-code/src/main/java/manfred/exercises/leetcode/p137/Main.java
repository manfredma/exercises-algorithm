/*
Given a non-empty array of integers, every element appears three times except for one,
which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

 */
package manfred.exercises.leetcode.p137;

/**
 * LeetCode 第 137 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
