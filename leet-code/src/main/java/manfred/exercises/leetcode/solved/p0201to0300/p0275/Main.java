package manfred.exercises.leetcode.solved.p0201to0300.p0275;

/*
给你一个整数数组 citations，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照非降序排列。
计算并返回该研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的
（n 篇论文中）至少有 h 篇论文分别被引用了至少 h 次。

请你设计并实现对数时间复杂度的算法解决此问题。
*/
/** LeetCode 第 275 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(3, solution.hIndex(new int[]{0, 1, 3, 5, 6}));
        assertEquals(2, solution.hIndex(new int[]{1, 2, 100}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
