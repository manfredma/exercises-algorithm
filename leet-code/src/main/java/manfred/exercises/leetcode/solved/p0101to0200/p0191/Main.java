/*
Write a function that takes an unsigned integer and return the number of '1' bits it has
(also known as the Hamming weight).

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

Note:

Note that in some languages such as Java, there is no unsigned integer type.
In this case, the input will be given as signed integer type and should not affect your implementation,
as the internal binary representation of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 3 above the input represents the signed integer -3.

Follow up:

If this function is called many times, how would you optimize it?

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0191;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/number-of-1-bits/ */

/**
 * LeetCode 第 191 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 3 的二进制 11，含 2 个 1（手算）
        assertEquals(2, new Solution2().hammingWeight(3));
        // 4 的二进制 100，含 1 个 1（手算）
        assertEquals(1, new Solution2().hammingWeight(4));
        // -3 的二进制 31 个 1（题面示例 3）
        assertEquals(31, new Solution2().hammingWeight(-3));
        System.out.println("p0191 passed");
    }
}
