package manfred.exercises.leetcode.p0347;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private final Solution solution = new Solution();
    private final Solution2 solution2 = new Solution2();

    // 题目允许任意顺序返回，断言前先排序
    @Test
    public void test1() {
        int[] result = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{1}, solution.topKFrequent(new int[]{1}, 1));
    }

    @Test
    public void test3() {
        int[] result = solution.topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void solution2Test1() {
        int[] result = solution2.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void solution2Test2() {
        assertArrayEquals(new int[]{1}, solution2.topKFrequent(new int[]{1}, 1));
    }

    @Test
    public void solution2Test3() {
        int[] result = solution2.topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result);
    }
}
