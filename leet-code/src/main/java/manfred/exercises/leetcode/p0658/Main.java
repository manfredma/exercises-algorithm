package manfred.exercises.leetcode.p0658;

import java.util.Arrays;
import java.util.List;

/*
给定一个排序好的数组 arr，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
返回的结果必须要是按升序排好的。

整数 a 比整数 b 更接近 x 需要满足：
|a - x| < |b - x| 或者 |a - x| == |b - x| 且 a < b。
*/
/** LeetCode 第 658 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(Arrays.asList(1, 2, 3, 4), solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        assertEquals(Arrays.asList(1, 1, 2, 3), solution.findClosestElements(new int[]{1, 1, 2, 3, 4, 5}, 4, -1));
    }

    private static void assertEquals(List<Integer> expected, List<Integer> actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
