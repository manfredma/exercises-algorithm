package manfred.exercises.leetcode.p0790;

// 备选解法：双状态 DP（数组版），与 Solution 的 O(1) 滚动变量版互为对照。
//
// 状态定义：
//   f[i] - 完整填满 2xi 面板的方法数
//   p[i] - 填满 2xi 面板但右上角缺一格的方法数（部分平铺）；
//         缺右下角与之上下对称、方法数相同，参与转移时乘 2
//
// 递推（按末尾如何收尾拆解）：
//   f[i] = f[i-1] + f[i-2] + 2 * p[i-1]
//   p[i] = p[i-1] + f[i-2]
//
// 边界：f[0]=1, f[1]=1, f[2]=2；p[0]=0, p[1]=0, p[2]=1。
// 时间 O(n)，空间 O(n)（可滚动到 O(1)，见 Solution）。
class Solution2 {

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long[] f = new long[n + 1];
        long[] p = new long[n + 1];
        f[0] = 1; f[1] = 1; f[2] = 2;
        p[0] = 0; p[1] = 0; p[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + f[i - 2] + 2 * p[i - 1]) % MOD;
            p[i] = (p[i - 1] + f[i - 2]) % MOD;
        }
        return (int) f[n];
    }
}
