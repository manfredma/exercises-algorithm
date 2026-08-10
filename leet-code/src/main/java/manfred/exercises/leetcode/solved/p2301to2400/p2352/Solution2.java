package manfred.exercises.leetcode.solved.p2301to2400.p2352;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rowCounts = new HashMap<>();
        for (int[] row : grid) {
            rowCounts.merge(toList(row), 1, Integer::sum);
        }

        int pairs = 0;
        for (int column = 0; column < grid.length; column++) {
            pairs += rowCounts.getOrDefault(columnOf(grid, column), 0);
        }
        return pairs;
    }

    private List<Integer> toList(int[] values) {
        List<Integer> result = new ArrayList<>(values.length);
        for (int value : values) {
            result.add(value);
        }
        return result;
    }

    private List<Integer> columnOf(int[][] grid, int column) {
        List<Integer> result = new ArrayList<>(grid.length);
        for (int[] row : grid) {
            result.add(row[column]);
        }
        return result;
    }
}
