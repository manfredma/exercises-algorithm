/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array,
you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

 */
package manfred.exercises.leetcode.solved.p0301to0400.p0344;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/reverse-string/ */

import java.util.Arrays;

/**
 * LeetCode 第 344 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例 1: 输入 ["h","e","l","l","o"] → 期望 ["o","l","l","e","h"]
        char[] input = new char[] {'h','e','l','l','o'};
        new Solution().reverseString(input);
        assertArrayEquals(new Character[] {'o','l','l','e','h'}, input);
        System.out.println("p0344 passed");
    }
}
