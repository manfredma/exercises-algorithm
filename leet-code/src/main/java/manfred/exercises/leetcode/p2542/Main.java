package manfred.exercises.leetcode.p2542;

/**
 * 选取 nums1 长度为 k 的子序列，分数为选中 nums1 的和乘以对应 nums2 的最小值。
 * 返回最大分数。示例输出分别为 12 和 30。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(12L, solution.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        assertEquals(30L, solution.maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1));

        // k 等于数组长度。
        assertEquals(6L, solution.maxScore(new int[]{1, 2, 3}, new int[]{3, 2, 1}, 3));
        // nums1、nums2 都允许出现 0。
        assertEquals(8L, solution.maxScore(new int[]{0, 5, 4}, new int[]{10, 0, 2}, 2));
        // 多个相同 nums2 值。
        assertEquals(10L, solution.maxScore(new int[]{1, 3, 2}, new int[]{2, 2, 2}, 2));
        // 分数超过 int 范围。
        assertEquals(1_000_000_000_000_000L,
                solution.maxScore(filled(100_000, 100_000), filled(100_000, 100_000), 100_000));
    }

    private static int[] filled(int length, int value) {
        int[] numbers = new int[length];
        java.util.Arrays.fill(numbers, value);
        return numbers;
    }

    private static void assertEquals(long expected, long actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
