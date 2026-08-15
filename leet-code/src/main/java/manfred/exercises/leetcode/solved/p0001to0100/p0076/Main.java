package manfred.exercises.leetcode.solved.p0001to0100.p0076;

/** 题目链接：https://leetcode.cn/problems/minimum-window-substring/ */

/*
给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。
如果没有这样的子串，返回空字符串 ""。

测试用例保证答案唯一。

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"

示例 2：

输入：s = "a", t = "a"
输出："a"

示例 3：

输入：s = "a", t = "aa"
输出：""

提示：

1 <= m, n <= 10^5

s 和 t 由英文字母组成
*/
/**
 * LeetCode 第 76 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: s = "ADOBECODEBANC", t = "ABC" → 期望 "BANC"
        assertAllSolutions(solution, solution2, solution3, "BANC", "ADOBECODEBANC", "ABC");
        // 示例 2: s = "a", t = "a" → 期望 "a"
        assertAllSolutions(solution, solution2, solution3, "a", "a", "a");
        // 示例 3: s = "a", t = "aa" → 期望 ""（t 中有两个 'a'，s 无法覆盖）
        assertAllSolutions(solution, solution2, solution3, "", "a", "aa");
        // 边界: s 与 t 完全相同 → 期望整个 s
        assertAllSolutions(solution, solution2, solution3, "ABC", "ABC", "ABC");
        // 边界: s 不含 t 全部字符 → 期望 ""
        assertAllSolutions(solution, solution2, solution3, "", "ABC", "ABCD");
        // 边界: 多个可行窗口，取最短 → 期望 "BA"
        assertAllSolutions(solution, solution2, solution3, "BA", "ADOBECODEBANCBA", "AB");
        // 重复字符: 覆盖 t 的重复需求后才能收缩 → 期望 "AABBC"
        assertAllSolutions(solution, solution2, solution3, "AABBC", "AAABBC", "AABC");
        // 前缀无关字符: 左指针必须跨过无关字符 → 期望 "BANC"
        assertAllSolutions(solution, solution2, solution3, "BANC", "ZZADOBECODEBANC", "ABC");
    }

    private static void assertAllSolutions(Solution solution, Solution2 solution2, Solution3 solution3,
                                           String expected, String s, String t) {
        assertEquals(expected, solution.minWindow(s, t));
        assertEquals(expected, solution2.minWindow(s, t));
        assertEquals(expected, solution3.minWindow(s, t));
    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
