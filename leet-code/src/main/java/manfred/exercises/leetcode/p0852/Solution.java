package manfred.exercises.leetcode.p0852;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                // 说明在上升的山坡，峰值在后面
                left = mid + 1;
            } else {
                // 说明当前在下降的山坡，峰值在前半段
                right = mid - 1;
            }
        }
        return 0;
    }
}
