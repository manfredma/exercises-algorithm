package manfred.exercises.leetcode.p0452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // 使用贪心算法来解决这个问题
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int result = 1;
        int arrowPos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                result++;
                arrowPos = points[i][1];
            }
        }
        return result;
    }
}
