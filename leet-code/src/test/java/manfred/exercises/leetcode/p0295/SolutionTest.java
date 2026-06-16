package manfred.exercises.leetcode.p0295;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(), 1e-5);
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(), 1e-5);
    }
}
