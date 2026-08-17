package manfred.exercises.leetcode.solved.p0901to1000.p0997;

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] out = new int[n+1];
        int[] in = new int[n+1];
        for (int[] t : trust) {
            out[t[0]]++;
            in[t[1]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
