/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0006;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/zigzag-conversion/ */

/**
 * LeetCode 第 6 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入 "01234567890123456789012345678901234"（长度 35），numRows=4，
        // 按 numRows=4 周期 6 分行读取后结果如下（手算逐行拼接）
        assertEquals("06284015713793591248046026824395173",
                solution.convert("01234567890123456789012345678901234", 4));
        System.out.println("p0006 passed");
    }
}
