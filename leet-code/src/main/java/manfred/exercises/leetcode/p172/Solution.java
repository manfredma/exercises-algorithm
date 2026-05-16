package manfred.exercises.leetcode.p172;

/**
 * LeetCode 第 172 题「阶乘后的零」：统计因子 5 的个数，每 5 的幂次贡献一个 0。
 */
class Solution {
    public int trailingZeroes(int n) {
        int result = 0;

        while (n > 0) {
            result += (n = n / 5);
        }

        return result;
    }
}