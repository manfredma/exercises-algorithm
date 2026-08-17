package manfred.exercises.leetcode.wip.p0227;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/basic-calculator-ii/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution / Solution2：保留验证，确保不被破坏（应通过）
        Solution solution = new Solution();
        assertEquals(42, solution.calculate("42"));
        assertEquals(7, solution.calculate("3+2*2"));
        assertEquals(1, solution.calculate("3/2"));
        assertEquals(5, solution.calculate(" 3+5 / 2 "));
        Solution2 solution2 = new Solution2();
        assertEquals(42, solution2.calculate("42"));
        assertEquals(7, solution2.calculate("3+2*2"));
        assertEquals(1, solution2.calculate("3/2"));
        assertEquals(5, solution2.calculate(" 3+5 / 2 "));
        // 新解法 Solution3：新增验证，骨架占位下 RED，待实现后通过
        Solution3 s3 = new Solution3();
        assertEquals(7, s3.calculate("3+2*2"));
        assertEquals(1, s3.calculate("3/2"));
        assertEquals(5, s3.calculate(" 3+5 / 2 "));
        assertEquals(42, s3.calculate("42"));
        assertEquals(0, s3.calculate("0")); // 边界：单 0
        System.out.println("leet#0227 passed");
    }
}
