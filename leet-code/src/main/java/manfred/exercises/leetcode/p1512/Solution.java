package manfred.exercises.leetcode.p1512;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[100];
        for (int i = 0; i < nums.length; i++) {
            count[--nums[i]]++;
        }
        int result = 0;
        for (int j : count) {
            if (j > 1) {
                result += j * (j - 1) / 2;
            }
        }
        return result;
    }
}
