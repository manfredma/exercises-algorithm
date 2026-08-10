package manfred.exercises.leetcode.solved.p0801to0900.p0875;

/** 题目链接：https://leetcode.cn/problems/koko-eating-bananas/ */

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根；
 * 若该堆少于 k 根，则吃完该堆，并且这一小时内不再吃更多香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小整数速度 k。
 *
 * 示例 1：piles = [3,6,7,11], h = 8，输出 4。
 * 示例 2：piles = [30,11,23,4,20], h = 5，输出 30。
 * 示例 3：piles = [30,11,23,4,20], h = 6，输出 23。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertEquals(4, solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        assertEquals(4, solution2.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        assertEquals(30, solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        assertEquals(30, solution2.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        assertEquals(23, solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        assertEquals(23, solution2.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
