package manfred.exercises.leetcode.p0416;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test1() {
        assertTrue(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    @Test
    public void test2() {
        assertFalse(solution.canPartition(new int[]{1, 2, 3, 5}));
    }
}
