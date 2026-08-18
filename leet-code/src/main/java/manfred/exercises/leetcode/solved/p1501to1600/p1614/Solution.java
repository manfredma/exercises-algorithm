package manfred.exercises.leetcode.solved.p1501to1600.p1614;

/**
 * LeetCode 第 1614 题「括号的最大嵌套深度」：计数器法，单趟扫描。
 * <p>
 * 思路：遇 '(' 当前深度 +1 并更新最大值，遇 ')' 深度 -1；非括号字符忽略。
 * 题目保证括号有效，故 curDepth 扫描结束必归零，无需校验。
 * 复杂度：时间 O(n)，空间 O(1)。本解已是 1614 题最优解。
 */
class Solution {
    public int maxDepth(String s) {
        int result = 0;
        int curDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                curDepth++;
                result = Math.max(result, curDepth);
            } else if (s.charAt(i) == ')') {
                curDepth--;
            }
        }
        return result;
    }
}
