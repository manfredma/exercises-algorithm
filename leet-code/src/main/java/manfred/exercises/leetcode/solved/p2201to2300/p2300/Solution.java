package manfred.exercises.leetcode.solved.p2201to2300.p2300;

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pair = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long)spells[i] * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            pair[i] = potions.length - left;
        }
        return pair;
    }
}
