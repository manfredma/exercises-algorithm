/*
Given a triangle, find the minimum path sum from top to bottom.
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space,
where n is the total number of rows in the triangle.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0120;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/triangle/ */

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 120 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：三角形 [[2],[3,4],[6,5,7],[4,1,8,3]] 最小路径和为 11 (2+3+5+1)
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        assertEquals(11, solution.minimumTotal(triangle));
        System.out.println("p0120 passed");
    }
}
