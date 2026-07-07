package manfred.exercises.leetcode.p0354;

import java.util.Arrays;

class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        // 宽度升序；宽度相同的按高度降序。
        // 同宽信封高度降序后，LIS 要求严格递增，同宽信封不可能同时被选中。
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        // 对高度序列做 LIS，patience sorting，O(n log n)
        int[] tails = new int[envelopes.length];
        int len = 0;
        for (int[] e : envelopes) {
            int h = e[1];
            int i = Arrays.binarySearch(tails, 0, len, h);
            if (i < 0) {
                i = -(i + 1); // 第一个 >= h 的位置
            }
            tails[i] = h;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
