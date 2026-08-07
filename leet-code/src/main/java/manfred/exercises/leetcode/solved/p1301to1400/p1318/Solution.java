package manfred.exercises.leetcode.solved.p1301to1400.p1318;

class Solution {
    public int minFlips(int a, int b, int c) {
        int minFlips = 0;
        for (int i = 0; i < 31; i++) {
            int bit = c & 1;
            if (bit == 1) {
                minFlips += ((a & 1) + (b & 1)) > 0 ? 0 : 1;
            } else {
                minFlips += (a & 1) + (b & 1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return minFlips;
    }
}
