package manfred.exercises.leetcode.p0459;

/*
给定一个非空的字符串 s，检查是否可以通过由它的一个子串重复多次构成。

示例 1：
输入：s = "abab"
输出：true

示例 2：
输入：s = "aba"
输出：false

示例 3：
输入：s = "abcabcabcabc"
输出：true

提示：
- 1 <= s.length <= 10^4
- s 由小写英文字母组成
*/
/**
 * LeetCode 第 459 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: s = "abab" → 期望 true
        System.out.println(solution.repeatedSubstringPattern("abab"));
        // 示例 2: s = "aba" → 期望 false
        System.out.println(solution.repeatedSubstringPattern("aba"));
        // 示例 3: s = "abcabcabcabc" → 期望 true
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
    }
}
