package manfred.exercises.leetcode.p0516;

/*
给你一个字符串 s，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
提示：1 <= s.length <= 1000，s 仅由小写英文字母组成。
*/

/**
 * LeetCode 第 516 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：s = "bbbab" → 期望 4
        System.out.println(solution.longestPalindromeSubseq("bbbab"));

        // 示例 2：s = "cbbd" → 期望 2
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }
}
