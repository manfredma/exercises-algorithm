package manfred.exercises.leetcode.solved.p1101to1200.p1111;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 注意：本题答案不唯一（任意合法拆分即可），用 assertValidSplit 校验合法性而非断言特定数组
        assertValidSplit("(()())", solution.maxDepthAfterSplit("(()())"));
        assertValidSplit("()(())()", solution.maxDepthAfterSplit("()(())()"));
        // 边界：深嵌套 / 并列 / 单层
        assertValidSplit("((()))", solution.maxDepthAfterSplit("((()))"));
        assertValidSplit("(((())))", solution.maxDepthAfterSplit("(((())))"));
        assertValidSplit("((((()))))", solution.maxDepthAfterSplit("((((()))))"));
        assertValidSplit("()()()", solution.maxDepthAfterSplit("()()()"));
        assertValidSplit("((()))(())", solution.maxDepthAfterSplit("((()))(())"));
        assertValidSplit("(()(()))", solution.maxDepthAfterSplit("(()(()))"));
        assertValidSplit("(((((())))))", solution.maxDepthAfterSplit("(((((())))))"));
        // 新解法 Solution2：奇偶深度交替分配验证（已实现，单趟 O(n)，复用合法性校验）
        Solution2 solution2 = new Solution2();
        assertValidSplit("(()())", solution2.maxDepthAfterSplit("(()())"));
        assertValidSplit("()(())()", solution2.maxDepthAfterSplit("()(())()"));
        assertValidSplit("((()))", solution2.maxDepthAfterSplit("((()))"));
        assertValidSplit("(((())))", solution2.maxDepthAfterSplit("(((())))"));
        assertValidSplit("((((()))))", solution2.maxDepthAfterSplit("((((()))))"));
        assertValidSplit("()()()", solution2.maxDepthAfterSplit("()()()"));
        assertValidSplit("((()))(())", solution2.maxDepthAfterSplit("((()))(())"));
        assertValidSplit("(()(()))", solution2.maxDepthAfterSplit("(()(()))"));
        assertValidSplit("(((((())))))", solution2.maxDepthAfterSplit("(((((())))))"));
        System.out.println("leet#1111 passed");
    }

    /**
     * 校验 maxDepthAfterSplit 的答案合法：
     * 1. answer 长度 = seq 长度
     * 2. 拆出的 A（answer[i]=0）与 B（answer[i]=1）都是有效括号串
     * 3. max(depth(A), depth(B)) = ceil(maxDepth(seq)/2)（理论最优）
     */
    private static void assertValidSplit(String seq, int[] answer) {
        String desc = "input=\"" + seq + "\"";
        // 长度校验
        if (answer.length != seq.length()) {
            fail(desc + " answer 长度 " + answer.length + " ≠ seq 长度 " + seq.length());
        }
        // 拆 A / B
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < seq.length(); i++) {
            if (answer[i] == 0) {
                a.append(seq.charAt(i));
            } else if (answer[i] == 1) {
                b.append(seq.charAt(i));
            } else {
                fail(desc + " answer[" + i + "]=" + answer[i] + " 非 0/1");
            }
        }
        // A、B 须为 VPS
        assertTrue(isVps(a.toString()), desc + " A=\"" + a + "\" 非有效括号串");
        assertTrue(isVps(b.toString()), desc + " B=\"" + b + "\" 非有效括号串");
        // max depth 达到理论最优 ceil(maxDepth(seq)/2)
        int maxDepthSeq = depth(seq);
        int optimal = (maxDepthSeq + 1) / 2;
        int achieved = Math.max(depth(a.toString()), depth(b.toString()));
        assertEquals(optimal, achieved, desc + " max(depth(A),depth(B))=" + achieved + " 未达最优 " + optimal);
    }

    /** 有效括号串校验：任意前缀右括号不超左，且总数相等。 */
    private static boolean isVps(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }

    /** 有效括号串的嵌套深度（假定合法）。 */
    private static int depth(String s) {
        int depth = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
                max = Math.max(max, depth);
            } else {
                depth--;
            }
        }
        return max;
    }
}
