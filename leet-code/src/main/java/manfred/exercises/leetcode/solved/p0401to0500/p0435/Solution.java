package manfred.exercises.leetcode.solved.p0401to0500.p0435;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 这个题目适合使用贪心算法来完成
        int eraseNum = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int smallestRight = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < smallestRight) {
                // 和已经选定保留的区间产生了重叠，则删除
                eraseNum++;
            } else {
                smallestRight = interval[1];
            }
        }
        return eraseNum;
    }
}
