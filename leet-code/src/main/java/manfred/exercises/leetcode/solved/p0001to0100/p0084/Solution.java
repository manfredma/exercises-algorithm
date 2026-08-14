package manfred.exercises.leetcode.solved.p0001to0100.p0084;

/**
 * LeetCode 第 84 题「柱状图中最大的矩形」（方案 1）：枚举每根柱子作为矩形的最低高度，
 * 向两侧扫描至首个更矮的柱子，从而得到该高度能覆盖的最大宽度。
 *
 * <p>这是便于理解的基线解法；最坏情况下每根柱子都要向两边扫描，时间复杂度为 O(n²)，
 * 空间复杂度为 O(1)。方案 2 和方案 3 使用单调递增栈将时间复杂度优化为 O(n)。</p>
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
