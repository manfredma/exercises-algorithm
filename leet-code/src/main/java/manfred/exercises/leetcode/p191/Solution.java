package manfred.exercises.leetcode.p191;

/**
 * LeetCode 第 191 题「位 1 的个数」：Brian Kernighan 算法 n & (n-1) 消去最低位 1。
 */
class Solution {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += (n >>> i) & 1;
        }
        return result;
    }
}