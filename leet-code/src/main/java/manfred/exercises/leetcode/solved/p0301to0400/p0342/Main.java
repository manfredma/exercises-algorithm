package manfred.exercises.leetcode.solved.p0301to0400.p0342;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/power-of-four/ */

/*
给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true；否则，返回 false。

整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x。

示例 1：
输入：n = 16
输出：true

示例 2：
输入：n = 5
输出：false

示例 3：
输入：n = 1
输出：true

提示：
-2^31 <= n <= 2^31 - 1

进阶：你能不使用循环或者递归来完成本题吗？
*/
/** LeetCode 第 342 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(true, solution.isPowerOfFour(16));
        assertEquals(false, solution.isPowerOfFour(5));
        assertEquals(true, solution.isPowerOfFour(1));
    }

}
