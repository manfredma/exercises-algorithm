package manfred.exercises.leetcode.p0238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = suffixProduct * answer[i];
            suffixProduct = suffixProduct * nums[i];
        }

        return answer;
    }
}
