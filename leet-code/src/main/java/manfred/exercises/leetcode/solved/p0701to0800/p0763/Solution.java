package manfred.exercises.leetcode.solved.p0701to0800.p0763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 划分字母区间 —— 区间合并解法。
 *
 * <p>思路：每个字母在字符串中占据一个 [首次出现, 末次出现] 的区间。只要两个字母的区间
 * 相交，它们就必须落在同一片段。把所有字母区间按起点排序后合并重叠区间，每个合并后的
 * 区间就是一个片段，其长度即为区间端点之差加一。
 *
 * <p>复杂度：时间 O(n + Σ log Σ)，空间 O(Σ)，其中 Σ 为字符集大小（本题小写字母 Σ=26）。
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSizes = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return partitionSizes;
        }

        int[][] intervals = buildIntervals(s);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] > current[1]) {
                // next 与当前区间不重叠：当前区间自洽，可切分为一个片段
                partitionSizes.add(current[1] - current[0] + 1);
                current = next;
            } else {
                // 区间重叠：同一片段内的字母必须合并，取更远的右端点
                current[1] = Math.max(current[1], next[1]);
            }
        }
        partitionSizes.add(current[1] - current[0] + 1);
        return partitionSizes;
    }

    /** 统计每个出现过的字母的 [首次出现, 末次出现] 区间，返回按字母序的区间数组。 */
    private int[][] buildIntervals(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        int[][] intervals = new int[26][2];
        int count = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1) {
                intervals[count++] = new int[]{first[c], last[c]};
            }
        }
        return Arrays.copyOf(intervals, count);
    }
}
