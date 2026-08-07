package manfred.exercises.leetcode.solved.p0301to0400.p0326;

class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
