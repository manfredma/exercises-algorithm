/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0091;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/decode-ways/ */

/**
 * LeetCode 第 91 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 手算："100" 中 "0" 单独无法解码，"10"=J 后接 "0" 无效，0 种
        assertEquals(0, solution.numDecodings("100"));
        // 手算："0" 单独无法解码，0 种
        assertEquals(0, solution.numDecodings("0"));
        // 题面示例 1："12" 可解码为 "AB"(1 2) 或 "L"(12)，共 2 种
        assertEquals(2, solution.numDecodings("12"));
        // 题面示例 2："226" 可解码为 "BZ"(2 26)、"VF"(22 6)、"BBF"(2 2 6)，共 3 种
        assertEquals(3, solution.numDecodings("226"));
        System.out.println("passed");
    }
}
