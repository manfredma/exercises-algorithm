package manfred.exercises.leetcode.solved.p0501to0600.p0528;

import java.util.Random;

class Solution {

    private int allWeight = 0;
    private final int[] sumWeight;
    private final Random random = new Random();

    public Solution(int[] w) {
        sumWeight = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            allWeight += w[i];
            sumWeight[i] = allWeight;
        }
    }

    public int pickIndex() {
        int x = random.nextInt(allWeight) + 1;
        int left  = 0, right = sumWeight.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sumWeight[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
