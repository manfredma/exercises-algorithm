package manfred.exercises.leetcode.p1523;

class Solution {
    public int countOdds(int low, int high) {
        return (high % 2 == 0) ? (high - low + 1) / 2 : (high - low) / 2 + 1;
    }
}
