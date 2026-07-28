package manfred.exercises.leetcode.p0268;

class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int num : nums) {
            result ^= num;
        }
        for (int i = 0; i <= n; i++) {
            result ^= i;
        }
        return result;
    }
}
