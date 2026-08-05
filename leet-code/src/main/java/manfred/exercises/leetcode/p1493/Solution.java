package manfred.exercises.leetcode.p1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int windowSize = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSize++;
            if (nums[i] == 0) {
                zeroCount++;
                // 开始尝试缩小窗口
                while (zeroCount > 1) {
                    if (nums[i - windowSize + 1] == 0) {
                        zeroCount--;
                    }
                    // 缩小窗口
                    windowSize--;
                }
            }
            result = Math.max(result, windowSize - 1);
        }
        return result;
    }
}
