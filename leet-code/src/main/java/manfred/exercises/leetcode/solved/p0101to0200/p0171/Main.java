/*

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0171;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/excel-sheet-column-number/ */

/**
 * LeetCode 第 171 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例 1
        assertEquals(1, solution.titleToNumber("A"));
        // 题面示例 2
        assertEquals(28, solution.titleToNumber("AB"));
        // 题面示例 3
        assertEquals(701, solution.titleToNumber("ZY"));
        System.out.println("p0171 passed");
    }
}
