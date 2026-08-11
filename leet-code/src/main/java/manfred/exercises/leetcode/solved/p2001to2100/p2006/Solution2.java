package manfred.exercises.leetcode.solved.p2001to2100.p2006;

class Solution2 {
    public int countKDifference(int[] nums, int k) {
        int result = 0;
        int[] numOcc = new int[101];
        for (int num : nums) {
            if (num - k >= 1) {
                result += numOcc[num - k];
            }
            if (num + k <= 100) {
                result += numOcc[num + k];
            }
            numOcc[num]++;
        }
        return result;
    }
}
