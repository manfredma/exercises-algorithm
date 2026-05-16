package manfred.exercises.leetcode.p011;

/**
 * LeetCode 第 11 题「盛最多水的容器」：双指针从两端向中间收缩，每次移动较短板。
 */
class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int minH = Math.min(height[i], height[j]);
                int tmp = minH * (j - i);
                if (tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }
}