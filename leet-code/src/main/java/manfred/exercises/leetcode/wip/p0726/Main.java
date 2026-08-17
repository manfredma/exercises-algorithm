package manfred.exercises.leetcode.wip.p0726;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/number-of-atoms/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals("H2O", solution.countOfAtoms("H2O"));
        assertEquals("H2MgO2", solution.countOfAtoms("Mg(OH)2"));
        assertEquals("K4N2O14S4", solution.countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println("leet#0726 passed");
    }
}
