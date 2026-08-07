package manfred.exercises.leetcode.solved.p0801to0900.p0875;

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low = 1, high = maxPile;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cost = Arrays.stream(piles).map(a -> (int)Math.ceil((double) a / mid)).sum();
            // 花费的时间较大时，需要尝试缩小左边界，是的速度变大
            if (cost > h) {
                 low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
