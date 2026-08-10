package manfred.exercises.leetcode.solved.p2301to2400.p2352;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> rowCount = new HashMap<>();
        int rowLen = grid.length;
        int columnLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            rowCount.merge(concat(grid, true, i), 1, Integer::sum);
        }

        for (int i = 0; i < columnLen; i++) {
            result += rowCount.getOrDefault(concat(grid, false, i), 0);
        }
        return result;
    }

    private String concat(int[][] grid, boolean row, int idx) {
        StringBuilder s = new StringBuilder();
        if (row) {
            int[] rowData = grid[idx];
            for (int j : rowData) {
                s.append(",").append(j);
            }
        } else {
            for (int[] ints : grid) {
                s.append(",").append(ints[idx]);
            }
        }
        return s.toString();
    }
}
