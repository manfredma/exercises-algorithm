package manfred.exercises.leetcode.solved.p0401to0500.p0441;

class Solution {
    public int arrangeCoins(int n) {
        // 寻找小于等于的第一个值
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long coinNum = (long)(1 + mid) * mid / 2;
            if (coinNum == n) {
                return mid;
            } else if (coinNum < n) {
                //
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
