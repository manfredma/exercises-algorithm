package manfred.exercises.leetcode.p0258;

/**
 * O(1) 数根(digital root)公式解法。
 *
 * <p>数学本质:反复求各位和直到一位数,结果等价于 num 对 9 取模,
 * 但结果落在 1..9(0 除外)。
 *
 * <p>公式:
 * <ul>
 *   <li>{@code num == 0} → 0</li>
 *   <li>否则 → {@code 1 + (num - 1) % 9}</li>
 * </ul>
 *
 * <p>为何 {@code (num - 1) % 9 + 1} 而非 {@code num % 9}:
 * 9 的数根是 9(不是 0),用 {@code num % 9} 会把 9、18、27… 错误映射到 0;
 * 减 1 再模 9、最后加 1,把 9 的倍数正确对齐到 9,其余落在 1..8。
 *
 * <p>时间 O(1),空间 O(1)。满足题目「不用循环/递归」的进阶要求。
 */
class Solution2 {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
