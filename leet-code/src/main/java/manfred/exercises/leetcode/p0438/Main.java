/*
给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]

示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]

提示:
- 1 <= s.length, p.length <= 3 * 10^4
- s 和 p 仅包含小写字母
*/
package manfred.exercises.leetcode.p0438;

/**
 * LeetCode 第 438 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // 期望: [0, 6]
        System.out.println(solution.findAnagrams("abab", "ab"));        // 期望: [0, 1, 2]
    }
}
