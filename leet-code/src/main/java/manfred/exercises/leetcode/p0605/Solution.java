package manfred.exercises.leetcode.p0605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlace = 0;
        int pre = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int cur = flowerbed[i];
            if (cur == 0 && pre == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                canPlace++;
                pre = 1;
            } else {
                pre = cur;
            }
        }
        return canPlace >= n;
    }
}
