package manfred.exercises.leetcode.solved.p0201to0300.p0228;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

/** 题目链接：https://leetcode.cn/problems/summary-ranges/ */

/**
 * LeetCode 第 228 题「汇总区间」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 题面 Output
        assertEquals(Arrays.asList("0->2", "4->5", "7"),
                solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        // 示例 2: 题面 Output
        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"),
                solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        // 示例 3: 题面 Output
        assertEquals(Collections.emptyList(), solution.summaryRanges(new int[]{}));
        // 示例 4: 题面 Output
        assertEquals(Arrays.asList("-1"), solution.summaryRanges(new int[]{-1}));
        // 示例 5: 题面 Output
        assertEquals(Arrays.asList("0"), solution.summaryRanges(new int[]{0}));

        SolutionV2 solutionV2 = new SolutionV2();
        assertEquals(Arrays.asList("0->2", "4->5", "7"),
                solutionV2.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"),
                solutionV2.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        assertEquals(Collections.emptyList(), solutionV2.summaryRanges(new int[]{}));
        assertEquals(Arrays.asList("-1"), solutionV2.summaryRanges(new int[]{-1}));
        assertEquals(Arrays.asList("0"), solutionV2.summaryRanges(new int[]{0}));
        System.out.println("p0228 passed");
    }
}
