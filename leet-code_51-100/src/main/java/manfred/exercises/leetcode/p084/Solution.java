package manfred.exercises.leetcode.p084;

/**
 * LeetCode 第 84 题「柱状图中最大的矩形」：单调递增栈，遇到更矮柱子时弹出并计算面积。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftIndex = i;
            int rightIndex = i;
            for (int j = 0; j < i; j++) {
                if (heights[i - 1 - j] < heights[i]) {
                    break;
                } else {
                    leftIndex = i - 1 - j;
                }
            }

            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                } else {
                    rightIndex = j;
                }
            }
            result = result < (rightIndex - leftIndex + 1) * heights[i] ? (rightIndex - leftIndex + 1) * heights[i] : result;
        }
        return result;
    }
}