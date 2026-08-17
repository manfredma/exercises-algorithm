/*

Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0188;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/ */

/**
 * LeetCode 第 188 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        // (2, [6,1,3,2,4,7])：运行输出 7，需复核
        assertEquals(7, solution.maxProfit(2, new int[]{6, 1, 3, 2, 4, 7}));
        // (2, [3,3,5,0,0,3,1,4])：运行输出 6，需复核
        assertEquals(6, solution.maxProfit(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        // 题面示例 1
        assertEquals(2, solution.maxProfit(2, new int[]{2, 4, 1}));
        // 题面示例 2
        assertEquals(7, solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println("p0188 passed");
    }
}
