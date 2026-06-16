package manfred.exercises.leetcode.p0279;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    @Test
    public void test1() {
        assertEquals(3, solution.numSquares(12));
    }

    @Test
    public void test2() {
        assertEquals(2, solution.numSquares(13));
    }

    @Test
    public void test1_solution2() {
        assertEquals(3, solution2.numSquares(12));
    }

    @Test
    public void test2_solution2() {
        assertEquals(2, solution2.numSquares(13));
    }
}
