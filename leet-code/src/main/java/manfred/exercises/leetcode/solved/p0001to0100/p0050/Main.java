package manfred.exercises.leetcode.solved.p0001to0100.p0050;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/powx-n/ */

/**
 * LeetCode 第 50 题「Pow(x, n)」的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1: 2.0^10 = 1024.0
        assertEquals(1024.0, solution.myPow(2.0, 10));
        // 题面示例 2: 2.1^3 = 9.261
        assertEquals(9.261, solution.myPow(2.1, 3), 1e-5);
        // 题面示例 3: 2.0^-2 = 0.25
        assertEquals(0.25, solution.myPow(2.0, -2));
        System.out.println("p0050 passed");
    }
}
