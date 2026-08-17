/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0058;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/length-of-last-word/ */

/**
 * LeetCode 第 58 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例："Hello World" 最后一个单词 "World" 长度为 5
        assertEquals(5, solution.lengthOfLastWord("Hello World"));
        System.out.println("passed");
    }
}
