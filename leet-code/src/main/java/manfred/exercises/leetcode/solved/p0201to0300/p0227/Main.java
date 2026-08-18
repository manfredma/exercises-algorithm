package manfred.exercises.leetcode.solved.p0201to0300.p0227;

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
        assertEquals(3, solution.calculate("1+2*3-4"));   // 乘后接减
        assertEquals(24, solution.calculate("2*3*4"));      // 连续乘
        assertEquals(20, solution.calculate("1+2*3*4-5")); // 混合
        Solution2 solution2 = new Solution2();
        assertEquals(42, solution2.calculate("42"));
        assertEquals(7, solution2.calculate("3+2*2"));
        assertEquals(1, solution2.calculate("3/2"));
        assertEquals(5, solution2.calculate(" 3+5 / 2 "));
        assertEquals(3, solution2.calculate("1+2*3-4"));
        assertEquals(24, solution2.calculate("2*3*4"));
        assertEquals(20, solution2.calculate("1+2*3*4-5"));
        // 新解法 Solution3：递归下降 + lastAdded 撤销技巧验证（已实现，含优先级边界）
        Solution3 s3 = new Solution3();
        assertEquals(7, s3.calculate("3+2*2"));
        assertEquals(1, s3.calculate("3/2"));
        assertEquals(5, s3.calculate(" 3+5 / 2 "));
        assertEquals(42, s3.calculate("42"));
        assertEquals(0, s3.calculate("0")); // 边界：单 0
        assertEquals(3, s3.calculate("1+2*3-4"));   // 乘后接减（lastAdded 技巧关键场景）
        assertEquals(24, s3.calculate("2*3*4"));     // 连续乘
        assertEquals(-5, s3.calculate("1-2*3"));     // 减后乘
        assertEquals(13, s3.calculate("14-3/2"));   // 减后除
        assertEquals(20, s3.calculate("1+2*3*4-5")); // 混合
        System.out.println("leet#0227 passed");
    }
}
