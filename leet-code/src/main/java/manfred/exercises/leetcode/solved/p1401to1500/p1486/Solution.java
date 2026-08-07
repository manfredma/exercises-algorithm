package manfred.exercises.leetcode.solved.p1401to1500.p1486;

class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
