package manfred.exercises.leetcode.wip.p1614;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(3, solution.maxDepth("(1+(2*3)+((8)/4))+1"));
        assertEquals(3, solution.maxDepth("(1)+((2))+(((3)))"));
        assertEquals(3, solution.maxDepth("()(())((()()))"));
        System.out.println("leet#1614 passed");
    }
}
