package manfred.exercises.leetcode.solved.p1501to1600.p1523;

class Solution {
    public int countOdds(int low, int high) {
        return (high % 2 == 0) ? (high - low + 1) / 2 : (high - low) / 2 + 1;
    }
}
