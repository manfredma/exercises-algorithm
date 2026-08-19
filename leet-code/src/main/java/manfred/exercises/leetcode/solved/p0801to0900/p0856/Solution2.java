package manfred.exercises.leetcode.solved.p0801to0900.p0856;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 第 856 题「括号的分数」：栈模拟。
 *
 * <p>栈保存每一层开始前已经累计的同层分数。遇到左括号时保存当前分数并从 0 开始
 * 计算内部；遇到右括号时，内部得分为 0 代表 {@code ()} 得 1 分，否则按规则得到
 * {@code 2 * inner}，再与弹出的同层累计分数相加。</p>
 *
 * <p>这版避免了递归边界和索引共享，时间复杂度 {@code O(n)}，栈空间 {@code O(n)}。</p>
 */
class Solution2 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> scores = new ArrayDeque<Integer>();
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                scores.push(score);
                score = 0;
            } else {
                int outerScore = scores.pop();
                score = outerScore + (score == 0 ? 1 : 2 * score);
            }
        }
        return score;
    }
}
