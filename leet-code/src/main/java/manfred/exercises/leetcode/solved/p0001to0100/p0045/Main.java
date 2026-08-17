/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0045;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/jump-game-ii/ */

/**
 * LeetCode 第 45 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(2, solution.jump(new int[]{2, 3, 1, 1, 4}));
        int[] i = new int[25002];
        for (int j = 0; j < 25000; j++) {
            i[j] = 25000 - j;
        }
        i[25000] = 1;
        i[25001] = 0;
        // 从索引 0 可直接跳到索引 25000，再跳 1 步到达末尾，最少 2 步
        assertEquals(2, solution.jump(i));
        System.out.println("p0045 passed");
    }
}
