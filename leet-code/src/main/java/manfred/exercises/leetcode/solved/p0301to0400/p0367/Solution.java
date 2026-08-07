package manfred.exercises.leetcode.solved.p0301to0400.p0367;

class Solution {
    public boolean isPerfectSquare(int num) {
        // 使用二分搜索来完成
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
