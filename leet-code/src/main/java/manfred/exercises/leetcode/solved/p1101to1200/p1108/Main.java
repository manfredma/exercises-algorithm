package manfred.exercises.leetcode.solved.p1101to1200.p1108;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/defanging-an-ip-address/ */

/**
 * LeetCode 第 1108 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        //  * Input: address = "1.1.1.1"
        // * Output: "1[.]1[.]1[.]1"
        // * Example 2:
        // *
        // * Input: address = "255.100.50.0"
        // * Output: "255[.]100[.]50[.]0"
        Solution solution = new Solution();
        assertEquals("1[.]1[.]1[.]1", solution.defangIPaddr("1.1.1.1"));
        assertEquals("255[.]100[.]50[.]0", solution.defangIPaddr("255.100.50.0"));
        System.out.println("passed");
    }
}
