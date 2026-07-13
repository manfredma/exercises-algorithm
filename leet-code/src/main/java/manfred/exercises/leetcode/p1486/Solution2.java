package manfred.exercises.leetcode.p1486;

/**
 * O(1) 数学解法(利用连续偶数异或的周期性)。
 *
 * <p>关键性质:任意连续 4 个整数异或结果为 0:
 * <pre>
 *   4k ^ (4k+1) ^ (4k+2) ^ (4k+3) = 0
 * </pre>
 * 因为每一位在 4 个连续数里都出现偶数次,异或抵消。
 *
 * <p>本题元素为 {@code start + 2i},全是偶/奇(取决于 start 奇偶),公差为 2。
 * 设 {@code s = start / 2}(右移一位,把「公差 2」压成「公差 1」),
 * 则原问题等价于求 {@code 2*((s) ^ (s+1) ^ ... ^ (s+n-1))} 的最低位补回 start 的奇偶位:
 *
 * <pre>
 *   xor(nums) = (xorRange(s, s+n-1) &lt;&lt; 1) | (n &amp; start &amp; 1)
 * </pre>
 *
 * <p>其中 {@code xorRange(a,b)} 是 [a,b] 区间异或,可由 {@code xorPrefix(b) ^ xorPrefix(a-1)}
 * 得到;{@code xorPrefix(x)} 按 {@code x % 4} 分四种情况 O(1) 算出:
 * <ul>
 *   <li>x % 4 == 0 → x</li>
 *   <li>x % 4 == 1 → 1</li>
 *   <li>x % 4 == 2 → x + 1</li>
 *   <li>x % 4 == 3 → 0</li>
 * </ul>
 *
 * <p>最后一项 {@code (n &amp; start &amp; 1)}:最低位只有当 n 为奇数且 start 为奇数时
 * 才凑出奇数个 1(异或得 1),否则全是偶数个或 0。
 *
 * <p>时间 O(1),空间 O(1)。比模拟解法快,但可读性差,仅作思路拓展。
 */
class Solution2 {
    public int xorOperation(int n, int start) {
        // 把公差 2 压成公差 1:start + 2i = 2*(start/2 + i) + (start & 1)
        // 区间 [s, s+n-1] 的异或,再左移 1;最低位单独处理
        int s = start >> 1;
        int rangeXor = xorPrefix(s + n - 1) ^ xorPrefix(s - 1);
        // 最低位:n 个 start&1 的异或 = (n 奇 且 start 奇) ? 1 : 0
        return (rangeXor << 1) | ((n & start) & 1);
    }

    /** [0, x] 区间内所有整数的异或,O(1)。 */
    private int xorPrefix(int x) {
        if (x < 0) {
            return 0;
        }
        switch (x & 3) {
            case 0: return x;
            case 1: return 1;
            case 2: return x + 1;
            default: return 0;   // case 3
        }
    }
}
