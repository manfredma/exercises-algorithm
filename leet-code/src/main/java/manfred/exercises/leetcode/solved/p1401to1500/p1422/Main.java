package manfred.exercises.leetcode.solved.p1401to1500.p1422;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/maximum-score-after-splitting-a-string/ */

/*
给你一个由若干 0 和 1 组成的字符串 s，将其分割成两个非空子字符串(左、右)。
得分 = 左子字符串中 0 的数量 + 右子字符串中 1 的数量。返回最大得分。
*/
/**
 * LeetCode 第 1422 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: s = "011101" → 期望 5
        assertEquals(5, solution.maxScore("011101"));
        // 示例 2: s = "00111" → 期望 5
        assertEquals(5, solution.maxScore("00111"));
        // 示例 3: s = "1111" → 期望 3
        assertEquals(3, solution.maxScore("1111"));
        System.out.println("passed");
    }
}
