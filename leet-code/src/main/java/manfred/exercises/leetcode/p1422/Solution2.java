package manfred.exercises.leetcode.p1422;

/**
 * delta 变形解法(单变量,与 Solution 等价但更紧凑)。
 *
 * <p>关键推导:把得分公式里的「右1」换成「全1 - 左1」:
 * <pre>
 *   得分 = 左0 + 右1 = 左0 + (全1 - 左1) = 全1 + (左0 - 左1)
 * </pre>
 * 全1 是常数,所以 {@code max(得分) = 全1 + max(左0 - 左1)}。
 *
 * <p>令 {@code delta = 左0 - 左1},遍历左部分字符:
 * {@code '0' → delta++},{@code '1' → delta--},取 {@code max(delta)}。
 * Solution 用 {@code left}/{@code right} 两个变量,本版合并为一个 {@code delta}。
 *
 * <p>时间 O(n),空间 O(1)。与 Solution 在数学上完全等价,不是更快,只是更紧凑。
 */
class Solution2 {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }
        int delta = 0;                                  // 左0 - 左1
        int maxDelta = Integer.MIN_VALUE;
        // i 是左末位,分割点 = i+1 ∈ [1, n-1](左右都非空)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                delta++;
            } else {
                delta--;
            }
            if (delta > maxDelta) {
                maxDelta = delta;
            }
        }
        return totalOnes + maxDelta;
    }
}
