package manfred.exercises.leetcode.solved.p1301to1400.p1318;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/ */

/**
 * 给你三个正整数 a、b 和 c。可以任意次翻转 a 和 b 二进制表示中的任意一位。
 * 返回使 a OR b == c 成立所需的最小翻转次数。
 *
 * 示例 1：a = 2, b = 6, c = 5，输出 3。
 * 示例 2：a = 4, b = 2, c = 7，输出 1。
 * 示例 3：a = 1, b = 2, c = 3，输出 0。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertSolutions(solution, solution2, 3, 2, 6, 5);
        assertSolutions(solution, solution2, 1, 4, 2, 7);
        assertSolutions(solution, solution2, 0, 1, 2, 3);

        // c 的某一位为 1，但 a、b 都没有该位。
        assertSolutions(solution, solution2, 1, 1, 1, 3);
        // c 的某一位为 0，a、b 都有该位，需要翻转两次。
        assertSolutions(solution, solution2, 3, 1, 1, 2);
        // 最高有效位附近的边界。
        assertSolutions(solution, solution2, 1, (1 << 29), 1, 1 << 29);
    }

    private static void assertSolutions(Solution solution, Solution2 solution2, int expected, int a, int b, int c) {
        assertEquals(expected, solution.minFlips(a, b, c));
        assertEquals(expected, solution2.minFlips(a, b, c));
    }

}
