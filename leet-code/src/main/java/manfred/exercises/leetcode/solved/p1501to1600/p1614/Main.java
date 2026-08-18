package manfred.exercises.leetcode.solved.p1501to1600.p1614;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 官方示例
        assertEquals(3, solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        assertEquals(3, solution.maxDepth("(1)+((2))+(((3)))"));
        assertEquals(3, solution.maxDepth("()(())((()()))"));
        // 边界：无括号 / 单层 / 纯嵌套 / 并列 / 深嵌套 / 表达式
        assertEquals(0, solution.maxDepth("1"));            // 无括号
        assertEquals(1, solution.maxDepth("()"));            // 单层
        assertEquals(3, solution.maxDepth("((()))"));       // 纯嵌套
        assertEquals(1, solution.maxDepth("()()()"));        // 并列单层
        assertEquals(4, solution.maxDepth("(((())))"));      // 深嵌套
        assertEquals(2, solution.maxDepth("1+(2*(3+4))"));   // 常规表达式
        assertEquals(0, solution.maxDepth("42"));            // 纯数字
        System.out.println("leet#1614 passed");
    }
}
