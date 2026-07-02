package manfred.exercises.leetcode.p0646;

import java.util.Arrays;

/**
 * 贪心解法：按右端点排序，每次尽量选右端点最小的数对，为后续留出更多空间。
 * 时间复杂度 O(n log n)，空间复杂度 O(1)。
 */
class Solution2 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }
}
