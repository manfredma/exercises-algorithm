/*

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0179;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/largest-number/ */

/**
 * LeetCode 第 179 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // [3,43,48,94,85,33,64,32,63,66]（运行输出，需复核）
        assertEquals("9485666463484333332", solution.largestNumber(new int[]{3, 43, 48, 94, 85, 33, 64, 32, 63, 66}));
        // 题面示例 1
        assertEquals("210", solution.largestNumber(new int[]{10, 2}));
        // 题面示例 2
        assertEquals("9534330", solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println("p0179 passed");
    }
}
