/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */
package manfred.exercises.leetcode.p067;

/**
 * LeetCode 第 67 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
}
