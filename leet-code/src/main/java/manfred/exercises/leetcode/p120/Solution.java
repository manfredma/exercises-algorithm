package manfred.exercises.leetcode.p120;

import java.util.List;

/**
 * LeetCode 第 120 题「三角形最小路径和」：动态规划，自底向上逐行更新最小路径和。
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> preRow = triangle.get(i - 1);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    row.set(j, row.get(j) + preRow.get(j));
                } else if (j == row.size() - 1) {
                    row.set(j, row.get(j) + preRow.get(j - 1));
                } else {
                    row.set(j, row.get(j) + Math.min(preRow.get(j - 1), preRow.get(j)));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            result = Math.min(triangle.get(triangle.size() - 1).get(j), result);
        }
        return result;
    }
}