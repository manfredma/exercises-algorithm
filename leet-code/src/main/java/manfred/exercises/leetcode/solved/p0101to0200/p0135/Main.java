/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0135;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/candy/ */

/**
 * LeetCode 第 135 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(13, solution.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        assertEquals(5, solution.candy(new int[]{1, 0, 2}));
        assertEquals(4, solution.candy(new int[]{1, 2, 2}));

        Solution2 solution2 = new Solution2();
        assertEquals(13, solution2.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        assertEquals(5, solution2.candy(new int[]{1, 0, 2}));
        assertEquals(4, solution2.candy(new int[]{1, 2, 2}));

        System.out.println("p0135 passed");
    }
}
