/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0149;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/max-points-on-a-line/ */

/**
 * LeetCode 第 149 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] → 4
        assertEquals(4, solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        // 示例 2: [[1,1],[2,2],[3,3]] → 3
        assertEquals(3, solution.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        // [[1,1],[1,1],[2,3]] → 3（重合点必共线，三点在同一直线上）
        assertEquals(3, solution.maxPoints(new int[][]{{1, 1}, {1, 1}, {2, 3}}));
        System.out.println("p0149 passed");
    }
}
