package exe201.bitwise.and.of.numbers.range;

/**
 * LeetCode 第 201 题「数字范围按位与」：对 m 和 n 同时右移直到相等，再左移恢复公共前缀。
 */
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        } else if (m == n) {
            return m;
        }

        for (int toZero = 0, x = m; toZero < 32; toZero++) {

            if ((m >>> toZero & 1) == 0) {

                if ((1 << toZero) + x >= n) {
                    break;
                } else {
                    x = x + (1 << toZero);
                }
            } else {
                m = m & ~(1 << toZero);
            }

        }
        return m;
    }
}