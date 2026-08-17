package manfred.exercises.leetcode.solved.p0501to0600.p0540;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/single-element-in-a-sorted-array/ */

/**
 * LeetCode 第 540 题（有序数组中的单一元素）的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 输入 [1, 2, 2, 3, 3] → 期望 1
        assertEquals(1, solution.singleNonDuplicate(new int[]{1, 2, 2, 3, 3}));

        System.out.println("p0540 passed");
    }
}
