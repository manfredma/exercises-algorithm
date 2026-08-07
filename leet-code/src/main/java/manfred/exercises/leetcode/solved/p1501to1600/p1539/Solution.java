package manfred.exercises.leetcode.solved.p1501to1600.p1539;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right -left) / 2;
            if (arr[mid] - mid - 1 >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + k ;
    }
}
