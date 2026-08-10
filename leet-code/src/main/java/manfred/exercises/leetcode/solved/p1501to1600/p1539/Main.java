package manfred.exercises.leetcode.solved.p1501to1600.p1539;

/** 题目链接：https://leetcode.cn/problems/kth-missing-positive-number/ */

/*
给你一个严格递增的正整数数组 arr 和一个整数 k。
请你找出并返回第 k 个缺失的正整数。
*/
/** LeetCode 第 1539 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(9, solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        assertEquals(6, solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
