package manfred.exercises.leetcode.p0875;

class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        while (low < high) {
            int speed = low + (high - low) / 2;
            if (canFinish(piles, h, speed)) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return low;
    }

    private int max(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}
