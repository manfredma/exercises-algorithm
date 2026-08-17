package manfred.exercises.leetcode.solved.p0201to0300.p0258;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/add-digits/ */

/*
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
*/
/**
 * LeetCode 第 258 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: num = 38 → 题面 Output: 2
        assertEquals(2, solution.addDigits(38));
        // 示例 2: num = 0 → 题面 Output: 0
        assertEquals(0, solution.addDigits(0));
        System.out.println("p0258 passed");
    }
}
