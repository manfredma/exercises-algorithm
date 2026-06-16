package manfred.exercises.leetcode.p0763;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    @Test
    public void test1() {
        assertEquals(Arrays.asList(9, 7, 8), solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test2() {
        assertEquals(Arrays.asList(10), solution.partitionLabels("eccbbbbdec"));
    }

    @Test
    public void test1_solution2() {
        assertEquals(Arrays.asList(9, 7, 8), solution2.partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test2_solution2() {
        assertEquals(Arrays.asList(10), solution2.partitionLabels("eccbbbbdec"));
    }
}
