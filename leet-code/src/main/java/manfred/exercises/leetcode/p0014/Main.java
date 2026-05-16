/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
package manfred.exercises.leetcode.p0014;

/**
 * LeetCode 第 14 题「最长公共前缀」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
