/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 */

package manfred.exercises.leetcode.solved.p0301to0400.p0387;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/first-unique-character-in-a-string/ */

/**
 * LeetCode 第 387 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 题面 Output: 0
        assertEquals(0, solution.firstUniqChar("leetcode"));
        // 示例 2: 题面 Output: 2
        assertEquals(2, solution.firstUniqChar("loveleetcode"));
        System.out.println("p0387 passed");
    }
}
