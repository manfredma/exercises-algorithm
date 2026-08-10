package manfred.exercises.leetcode.solved.p0201to0300.p0214;

/** 题目链接：https://leetcode.cn/problems/shortest-palindrome/ */

/**
 * LeetCode 第 214 题「最短回文串」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("aacecaaa").equals("aaacecaaa"));

        System.out.println(solution.shortestPalindrome("aaaa").equals("aaaa"));
        System.out.println(solution.shortestPalindrome("abcd").equals("dcbabcd"));
        System.out.println(solution.shortestPalindrome("a").equals("a"));
        System.out.println(solution.shortestPalindrome("").equals(""));
    }
}
