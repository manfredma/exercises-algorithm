package manfred.exercises.leetcode.solved.p0201to0300.p0264;

import static manfred.exercises.assertion.Assert.*;

/**
 * LeetCode 第 0264 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/ugly-number-ii/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        // 示例 1: n = 10 → 12
        assertEquals(12, solution.nthUglyNumber(10), "n=10");
        assertEquals(12, solution2.nthUglyNumber(10), "Solution2 n=10");

        // 示例 2: n = 1 → 1
        assertEquals(1, solution.nthUglyNumber(1), "n=1");
        assertEquals(1, solution2.nthUglyNumber(1), "Solution2 n=1");

        // 边界: 第二个丑数
        assertEquals(2, solution.nthUglyNumber(2), "n=2");
        assertEquals(2, solution2.nthUglyNumber(2), "Solution2 n=2");

        // 边界: n=6 → 6（连续段 1,2,3,4,5,6 均为丑数）
        assertEquals(6, solution.nthUglyNumber(6), "n=6");
        assertEquals(6, solution2.nthUglyNumber(6), "Solution2 n=6");

        // 边界: n=7 → 8（跳过 7，因 7 非 2/3/5 因子）
        assertEquals(8, solution.nthUglyNumber(7), "n=7");
        assertEquals(8, solution2.nthUglyNumber(7), "Solution2 n=7");

        // 边界: n=11 → 15（3×5 首次出现）
        assertEquals(15, solution.nthUglyNumber(11), "n=11");
        assertEquals(15, solution2.nthUglyNumber(11), "Solution2 n=11");

        // 上界: n=1690 → 2123366400（题目最大范围，值在 int 范围内）
        assertEquals(2123366400, solution.nthUglyNumber(1690), "n=1690");
        assertEquals(2123366400, solution2.nthUglyNumber(1690), "Solution2 n=1690");

        System.out.println("leet#0264 passed");
    }
}
