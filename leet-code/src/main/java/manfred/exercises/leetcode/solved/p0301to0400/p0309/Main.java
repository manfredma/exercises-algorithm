/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
package manfred.exercises.leetcode.solved.p0301to0400.p0309;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/ */

/**
 * LeetCode 第 309 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例: 输入 [1,2,3,0,2] → 期望 3
        assertEquals(3, solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println("p0309 passed");
    }
}
