package manfred.exercises.leetcode.p0338;

class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                // 当前最低位是 1 的话，其值为上一个数+1
                result[i] = result[i - 1] + 1;
            } else {
                // 最低位不为 1，则直接移除就行
                result[i] = result[i >> 1];
            }

        }
        return result;
    }
}
