/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0060;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/permutation-sequence/ */

/**
 * LeetCode 第 60 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 手算：n=3 全排列序列 123,132,213,231,312,321，第 2 个为 "132"
        assertEquals("132", solution.getPermutation(3, 2));
        // 手算：第 1 个为 "123"
        assertEquals("123", solution.getPermutation(3, 1));
        // 题面示例 1：n=3, k=3 -> "213"
        assertEquals("213", solution.getPermutation(3, 3));
        // 题面示例 2：n=4, k=9 -> "2314"
        assertEquals("2314", solution.getPermutation(4, 9));
        System.out.println("passed");
    }
}
