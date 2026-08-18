package manfred.exercises.leetcode.wip.p0736;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/parse-lisp-expression/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(14, solution.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"), "input=\"(let x 2 ...(add x y)))\"");
        assertEquals(2, solution.evaluate("(let x 3 x 2 x)"), "input=\"(let x 3 x 2 x)\"");
        assertEquals(5, solution.evaluate("(let x 1 y 2 x (add x y) (add x y))"), "input=\"(let x 1 y 2 ...)\"");
        System.out.println("leet#0736 passed");
    }
}
