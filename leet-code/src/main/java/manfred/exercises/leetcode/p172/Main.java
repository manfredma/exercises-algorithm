/*

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.

 */
package manfred.exercises.leetcode.p172;

/**
 * LeetCode 第 172 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
    }
}
