package manfred.exercises.leetcode.solved.p3101to3200.p3110;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 3110 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/score-of-a-string/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：s = "hello" → 13
        assertEquals(13, solution.scoreOfString("hello"), "input=\"hello\"");

        // 示例 2：s = "zaz" → 50（z-a 差 25，出现两次）
        assertEquals(50, solution.scoreOfString("zaz"), "input=\"zaz\"");

        // 边界·最短长度 2 且相同字符：差值为 0
        assertEquals(0, solution.scoreOfString("aa"), "input=\"aa\"");

        // 边界·最短长度 2 且相邻字符：a→b 差 1
        assertEquals(1, solution.scoreOfString("ab"), "input=\"ab\"");

        // 边界·相邻相同字符段贡献 0：s = "aabb" → |a-a|+|a-b|+|b-b| = 0+1+0 = 1
        assertEquals(1, solution.scoreOfString("aabb"), "input=\"aabb\"");

        // 边界·单调递减单步差最大：z→a 反复，s = "za" → 25
        assertEquals(25, solution.scoreOfString("za"), "input=\"za\"");

        System.out.println("leet#3110 passed");
    }
}
