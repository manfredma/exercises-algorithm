package manfred.exercises.leetcode.p0354;

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // 按照宽度排序之后就不需要再考虑宽度，因为最终的结果肯定是这个顺序下的一个子序列
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int[] max = new int[envelopes.length];
        // 最少是可以放入一封
        Arrays.fill(max, 1);
        int result = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] == envelopes[j][0]) {
                    // 不需要继续循环，已经到和自己宽度相同的信封了
                    break;
                }
                if (envelopes[i][1] > envelopes[j][1]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                    result = Math.max(result, max[i]);
                }
            }
        }
        return result;
    }
}
