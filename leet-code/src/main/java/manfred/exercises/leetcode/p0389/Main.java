package manfred.exercises.leetcode.p0389;

/*
给定两个字符串 s 和 t，t 由 s 随机重排后在随机位置添加一个字母。
请找出在 t 中被添加的字母。

示例 1：
输入：s = "abcd", t = "abcde"
输出："e"

示例 2：
输入：s = "", t = "y"
输出："y"

提示：
- 0 <= s.length <= 1000
- t.length == s.length + 1
- s 和 t 只包含小写字母
*/
/**
 * LeetCode 第 389 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // 示例 1: s="abcd", t="abcde" → 期望 'e'
        System.out.println(solution.findTheDifference("abcd", "abcde"));
        // 示例 2: s="", t="y" → 期望 'y'
        System.out.println(solution.findTheDifference("", "y"));
    }
}
