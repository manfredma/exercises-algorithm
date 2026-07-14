package manfred.exercises.leetcode.p0436;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        // 按起点排序，构建 {start, 原下标} 的数组
        int[][] sortedStarts = new int[len][2];
        for (int i = 0; i < len; i++) {
            sortedStarts[i] = new int[]{intervals[i][0], i};
        }
        Arrays.sort(sortedStarts, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int target = intervals[i][1];
            int search = Arrays.binarySearch(sortedStarts, new int[]{target}, Comparator.comparingInt(a -> a[0]));
            if (search < 0) {
                search = -(search + 1);
            }
            result[i] = search >= len ? -1 : sortedStarts[search][1];
        }
        return result;
    }
}
