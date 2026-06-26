package manfred.exercises.leetcode.p0709;

/*
给你一个字符串 s，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
提示：1 <= s.length <= 100，s 由 ASCII 字符集中的可打印字符组成。
*/

/**
 * LeetCode 第 709 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：s = "Hello" → 期望 "hello"
        System.out.println(solution.toLowerCase("Hello"));

        // 示例 2：s = "here" → 期望 "here"
        System.out.println(solution.toLowerCase("here"));

        // 示例 3：s = "LOVELY" → 期望 "lovely"
        System.out.println(solution.toLowerCase("LOVELY"));
    }
}
