package manfred.exercises.leetcode.p2586;

/*
给你字符串数组 words 和两个整数 left、right。
元音字符串:以元音字母(a/e/i/o/u)开头且以元音字母结尾。
返回 words[left..right] 内元音字符串的数目。
*/
/**
 * LeetCode 第 2586 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: words = ["are","amy","u"], left = 0, right = 2 → 期望 2
        System.out.println(solution.vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        // 示例 2: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4 → 期望 3
        System.out.println(solution.vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4));
    }
}
