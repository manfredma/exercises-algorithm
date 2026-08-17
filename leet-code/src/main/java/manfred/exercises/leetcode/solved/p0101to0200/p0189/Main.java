/*

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0189;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/rotate-array/ */

/**
 * LeetCode 第 189 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 题面示例 1
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution2 solution = new Solution2();
        solution.rotate(input, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, input);

        // [1,2,3,4,5,6] k=2：右旋两步为 [5,6,1,2,3,4]（手算确认）
        input = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(input, 2);
        assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, input);

        System.out.println("p0189 passed");
    }
}
