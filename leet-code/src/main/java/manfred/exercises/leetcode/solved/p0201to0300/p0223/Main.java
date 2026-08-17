package manfred.exercises.leetcode.solved.p0201to0300.p0223;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/rectangle-area/ */

/**
 * LeetCode 第 223 题「矩形面积」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 题面 Output: 45
        assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        // 示例 2: 题面 Output: 16（两矩形重合，总面积即一个矩形面积）
        assertEquals(16, solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        // 自造用例: 两矩形为内含关系，矩形2完全落在矩形1内，并集面积=矩形1面积=16
        assertEquals(16, solution.computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
        System.out.println("p0223 passed");
    }
}
