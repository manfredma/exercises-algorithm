package manfred.exercises.leetcode.p0042;

/**
 * LeetCode 第 42 题「接雨水」：双指针或单调栈，计算每列能接的水量。
 */
class Solution {
    public int trap(int[] height) {
        if (null == height || height.length <= 2) {
            return 0;
        }
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftH[i] = Math.max(height[i -1], leftH[i -1]);
            rightH[height.length - 1 - i] = Math.max(height[height.length - 1 - i + 1], rightH[height.length - 1 -i + 1]);
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            if (leftH[i] > height[i] && rightH[i] > height[i]) {
                result += Math.min(leftH[i], rightH[i]) - height[i];
            }
        }
        return result;
    }
}