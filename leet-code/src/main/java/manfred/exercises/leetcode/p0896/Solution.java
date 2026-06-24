package manfred.exercises.leetcode.p0896;

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean smaller = false;
        boolean bigger = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                bigger = true;
            } else if (nums[i] < nums[i - 1]) {
                smaller = true;
            }
        }
        return !(bigger && smaller);
    }
}
