package manfred.exercises.leetcode.solved.p1001to1100.p1004;

class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        // 维护反转 K 个 0 的窗口
        int windownSize = 0;
        int longestOnes = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            longestOnes++;
            if (nums[i] == 0) {
                // 先撑大窗口，然后尝试将窗口收缩到合法的范围
                windownSize++;
                while (windownSize > k) {
                    longestOnes--;
                    if (nums[left] == 0) {
                        windownSize--;
                    }
                    left++;
                }
            }
            result = Math.max(result, longestOnes);
        }

        return result;
    }
}
