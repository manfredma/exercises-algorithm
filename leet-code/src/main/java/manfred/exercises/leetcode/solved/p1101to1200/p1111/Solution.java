package manfred.exercises.leetcode.solved.p1101to1200.p1111;

/**
 * LeetCode 第 1111 题「有效括号的嵌套深度」：深度分界法，两趟扫描。
 * <p>
 * 思路：先扫一趟求原串最大深度 maxDepth，取 aDepth = maxDepth/2 作分界。
 * 第二趟按当前深度（遇 '(' 增、遇 ')' 减）填 result——深度 > aDepth 的括号分给 B(1)，
 * 其余分给 A(0)。这使 A/B 深度均衡到 ceil(maxDepth/2) 的理论最优。
 * <p>
 * 关键点：遇 ')' 时先按当前深度（与配对 '(' 同深度）判断再减，保证配对括号分到同一组。
 * 复杂度：时间 O(n)，空间 O(n)（结果数组）。答案不唯一，本解输出任一合法最优拆分。
 */
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        // 如果要满足最小，那么需要将最大深度均分（如果是最大深度为奇数的，则拆分后的 1 或 2 其中就多一个1）.核心就是将关键路径均分即可
        int maxDepth = 0;
        int curDepth = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == ')') {
                curDepth--;
            } else {
                curDepth++;
                maxDepth = Math.max(maxDepth, curDepth);
            }
        }

        int aDepth = maxDepth / 2;
        int[] result = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == ')') {
                if (curDepth > aDepth) {
                    // 退出前，需要计算是否设值，因为当前")"的深度与配对的 “(” 相同
                    result[i] = 1;
                }
                curDepth--;
            } else {
                curDepth++;
                if (curDepth > aDepth) {
                    result[i] = 1;
                }
            }
        }
        return result;
    }
}
