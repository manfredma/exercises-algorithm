package manfred.exercises.leetcode.wip.p1111;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 注意：本题答案不唯一（任意合法拆分即可），这里用官方示例输出做断言
        assertEquals(new int[]{0, 1, 1, 1, 1, 0}, solution.maxDepthAfterSplit("(()())"));
        assertEquals(new int[]{0, 0, 0, 1, 1, 0, 1, 1}, solution.maxDepthAfterSplit("()(())()"));
        System.out.println("leet#1111 passed");
    }
}
