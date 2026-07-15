package manfred.exercises.leetcode.p0790;

class Solution {


    public int numTilings(int n) {
        int mod = 1000_000_000 + 7;
        if (n == 1) {
            return 1;
        }

        // 以下初始化的都是 n = 2 的初始值：
        long x = 2; // 用以表示平铺了 n 的方式的数量
        long preX = 1; // 为了与 L 砖 结合，初始化是：n = 1 的排列数
        long y = 2; // 缺一角的排列情况
        for (int i = 3; i <= n; i++) {
            long tmpX = x;
            x = (tmpX + preX + y) % mod;
            y = (2 * preX + y) % mod;
            preX = tmpX;
        }
        return (int)x;
    }
}
