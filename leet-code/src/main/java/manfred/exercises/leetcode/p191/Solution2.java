package manfred.exercises.leetcode.p191;

/**
 * LeetCode 第 191 题「位 1 的个数」（方案2）：Brian Kernighan 算法 n & (n-1) 消去最低位 1。
 */
class Solution2 {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n &= (n - 1);
        }
        return result;
    }
}