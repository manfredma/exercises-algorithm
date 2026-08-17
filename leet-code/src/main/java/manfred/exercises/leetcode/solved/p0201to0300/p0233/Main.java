package manfred.exercises.leetcode.solved.p0201to0300.p0233;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/number-of-digit-one/ */

/**
 * LeetCode 第 233 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例: n=13, 1..13 中数字 1 出现 6 次（1,10,11×2,12,13）
        assertEquals(6, solution.countDigitOne(13));
        // 边界: n=0, 无任何数, 出现 0 次
        assertEquals(0, solution.countDigitOne(0));
        // 手算: n=12, 1,10,11×2,12 共 5 次
        assertEquals(5, solution.countDigitOne(12));
        // 手算: n=20, 1,10,11×2,12..19 各 1 次, 共 12 次
        assertEquals(12, solution.countDigitOne(20));

        SolutionV2 solutionV2 = new SolutionV2();
        assertEquals(6, solutionV2.countDigitOne(13));
        assertEquals(0, solutionV2.countDigitOne(0));
        assertEquals(5, solutionV2.countDigitOne(12));
        assertEquals(12, solutionV2.countDigitOne(20));
        System.out.println("p0233 passed");
    }
}
