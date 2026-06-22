package manfred.exercises.leetcode.p1071;

/*
对于字符串 s 和 t，只有在 s = t + t + ... + t 时，才认定"t 能除尽 s"。
给定两个字符串 str1 和 str2，返回最长字符串 x，要求 x 能除尽 str1 且能除尽 str2。

示例 1：
输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"

示例 2：
输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"

示例 3：
输入：str1 = "LEET", str2 = "CODE"
输出：""

示例 4：
输入：str1 = "AAAAAB", str2 = "AAA"
输出：""

提示：
- 1 <= str1.length, str2.length <= 1000
- str1 和 str2 由大写英文字母组成
*/
/**
 * LeetCode 第 1071 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: str1="ABCABC", str2="ABC" → 期望 "ABC"
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
        // 示例 2: str1="ABABAB", str2="ABAB" → 期望 "AB"
        System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));
        // 示例 3: str1="LEET", str2="CODE" → 期望 ""
        System.out.println(solution.gcdOfStrings("LEET", "CODE"));
        // 示例 4: str1="AAAAAB", str2="AAA" → 期望 ""
        System.out.println(solution.gcdOfStrings("AAAAAB", "AAA"));
    }
}
