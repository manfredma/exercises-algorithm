/*

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
package manfred.exercises.leetcode.solved.p0201to0300.p0204;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/count-primes/ */

/**
 * LeetCode 第 204 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例: 10 → 4 (素数 2,3,5,7)
        assertEquals(4, solution.countPrimes(10));
        System.out.println("p0204 passed");
    }
}
