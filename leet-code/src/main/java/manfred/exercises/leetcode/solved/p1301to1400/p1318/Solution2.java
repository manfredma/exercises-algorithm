package manfred.exercises.leetcode.solved.p1301to1400.p1318;

class Solution2 {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount(a & ~c)
                + Integer.bitCount(b & ~c)
                + Integer.bitCount(c & ~(a | b));
    }
}
