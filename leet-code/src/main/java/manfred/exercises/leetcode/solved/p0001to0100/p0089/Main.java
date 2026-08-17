/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0089;

import static manfred.exercises.assertion.Assert.*;

import java.util.List;

/** 题目链接：https://leetcode.cn/problems/gray-code/ */

/**
 * LeetCode 第 89 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n=2 → 长度 4，起始为 0，相邻两数仅差一位（格雷码性质），顺序不唯一
        List<Integer> r2 = solution.grayCode(2);
        assertEquals(4, r2.size());
        assertEquals(0, (int) r2.get(0));
        assertTrue(isValidGrayCode(r2));
        // 示例 2: n=0 → [0]
        List<Integer> r0 = solution.grayCode(0);
        assertEquals(1, r0.size());
        assertEquals(0, (int) r0.get(0));
        System.out.println("p0089 passed");
    }

    /** 校验格雷码序列：首项为 0，长度为 2^n，任意相邻两项仅有一位二进制位不同。 */
    private static boolean isValidGrayCode(List<Integer> code) {
        for (int i = 1; i < code.size(); i++) {
            if (Integer.bitCount(code.get(i) ^ code.get(i - 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
