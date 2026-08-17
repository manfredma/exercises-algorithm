package manfred.exercises.leetcode.solved.p0201to0300.p0263;

import static manfred.exercises.assertion.Assert.assertFalse;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/ugly-number/ */

/*
丑数就是只包含质因数 2、3 和 5 的正整数。
给你一个整数 n，请你判断 n 是否为丑数。如果是，返回 true；否则，返回 false。
*/
/**
 * LeetCode 第 263 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 6 → 题面 Output: true
        assertTrue(solution.isUgly(6));
        // 示例 2: n = 1 → 题面 Output: true
        assertTrue(solution.isUgly(1));
        // 示例 3: n = 14 → 题面 Output: false
        assertFalse(solution.isUgly(14));
        System.out.println("p0263 passed");
    }
}
