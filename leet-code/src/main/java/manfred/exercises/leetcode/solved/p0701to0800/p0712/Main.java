package manfred.exercises.leetcode.solved.p0701to0800.p0712;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/ */

/*
给定两个字符串 s1 和 s2，返回使两个字符串相等所需删除字符的 ASCII 值的最小和。
提示：1 <= s1.length, s2.length <= 1000，s1 和 s2 由小写英文字母组成。
*/
/**
 * LeetCode 第 712 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: s1 = "sea", s2 = "eat" → 期望 231
        assertEquals(231, solution.minimumDeleteSum("sea", "eat"));

        // 示例 2: s1 = "delete", s2 = "leet" → 期望 403
        assertEquals(403, solution.minimumDeleteSum("delete", "leet"));

        System.out.println("p0712 passed");
    }
}
