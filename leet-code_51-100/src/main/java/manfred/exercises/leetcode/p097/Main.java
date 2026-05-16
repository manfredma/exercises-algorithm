/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
 */
package manfred.exercises.leetcode.p097;

/**
 * LeetCode 第 97 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution2.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        Solution solution = new Solution();
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

    }
}
