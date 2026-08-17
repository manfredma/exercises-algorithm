package manfred.exercises.ctci.c0105;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.05「一次编辑」的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        SolutionV2 solutionV2 = new SolutionV2();
        // 书/题面示例：删除一个字符 e
        assertTrue(solutionV2.oneEditAway("pale", "ple"));
        // 手算：完全相同，0 次编辑
        assertTrue(solutionV2.oneEditAway("pales", "pales"));
        // 题面示例：长度差 2 > 1
        assertFalse(solutionV2.oneEditAway("pales", "pal"));
        // 手算：插入一个字符 a
        assertTrue(solutionV2.oneEditAway("", "a"));

        Solution solution = new Solution();
        assertTrue(solution.oneEditAway("pale", "ple"));
        assertTrue(solution.oneEditAway("pales", "pales"));
        assertFalse(solution.oneEditAway("pales", "pal"));
        assertTrue(solution.oneEditAway("", "a"));
        System.out.println("passed");
    }
}
