package exe231.power.of.two;

/**
 * LeetCode 第 231 题「2 的幂」：位运算 n > 0 && (n & (n-1)) == 0。
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}