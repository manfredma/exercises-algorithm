package manfred.exercises.leetcode.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LeetCode 第 56 题「合并区间」：排序后按起点合并重叠区间。
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int c = Integer.compare(o1[0], o2[0]);
                if (c == 0) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return c;
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] cur = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] > cur[1]) {
                result.add(cur);
                cur = new int[]{next[0], next[1]};
                continue;
            }
            if (cur[1] < next[1]) {
                cur[1] = next[1];
            }

        }
        result.add(cur);
        return result.toArray(new int[result.size()][]);
    }
}