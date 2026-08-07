package manfred.exercises.leetcode.solved.p2401to2500.p2413;

class Solution {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : n << 1;
    }
}
