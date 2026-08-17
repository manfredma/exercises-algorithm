/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0168;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/excel-sheet-column-title/ */

/**
 * LeetCode 第 168 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 2 / 注释
        assertEquals("AB", solution.convertToTitle(28));
        // AJHX（注释/运行确认）
        assertEquals("AJHX", solution.convertToTitle(24568));
        // B（手算：2 -> B）
        assertEquals("B", solution.convertToTitle(2));
        // 题面示例 3
        assertEquals("ZY", solution.convertToTitle(701));
        // AZ（手算：52 = 1*26 + 26 -> AZ）
        assertEquals("AZ", solution.convertToTitle(52));
        System.out.println("p0168 passed");
    }
}
