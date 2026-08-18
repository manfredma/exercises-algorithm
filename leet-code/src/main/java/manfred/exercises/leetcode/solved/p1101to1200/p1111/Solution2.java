package manfred.exercises.leetcode.solved.p1101to1200.p1111;

/**
 * LeetCode 第 1111 题「有效括号的嵌套深度」：再刷解法，奇偶深度交替分配，单趟 O(n)。
 * <p>
 * 思路：按当前嵌套深度 curDepth 的奇偶性分组——result[i] = curDepth % 2。
 * 遇 '(' 先 ++ 再取（进入该层后的深度奇偶），遇 ')' 先取再 --（与配对 '(' 同深度，保证同组）。
 * 奇数层与偶数层各分一组，使 A/B 深度差至多 1，达到 ceil(maxDepth/2) 的理论最优。
 * <p>
 * 关键点：配对括号用同一深度判断，保证分到同一组（VPS 合法性的前提）。
 * 复杂度：时间 O(n) 单趟，空间 O(n)（结果数组）。答案不唯一，本解输出任一合法最优拆分。
 * <p>
 * 与 {@link Solution} 对比：旧解两趟（先求 maxDepth 再按 aDepth=maxDepth/2 分界）；
 * 本解无需预处理 maxDepth，奇偶交替直接达到同样最优，更简洁。
 */
class Solution2 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int curDepth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == ')') {
                result[i] = curDepth-- % 2;
            } else {
                result[i] = ++curDepth % 2;
            }
        }
        return result;
    }
}
