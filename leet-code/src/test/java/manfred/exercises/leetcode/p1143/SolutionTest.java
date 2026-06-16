package manfred.exercises.leetcode.p1143;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    @Test
    public void test1() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void test2() {
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    public void test3() {
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
    }

    @Test
    public void test1_solution2() {
        assertEquals(3, solution2.longestCommonSubsequence("abcde", "ace"));
    }

    @Test
    public void test2_solution2() {
        assertEquals(3, solution2.longestCommonSubsequence("abc", "abc"));
    }

    @Test
    public void test3_solution2() {
        assertEquals(0, solution2.longestCommonSubsequence("abc", "def"));
    }
}
