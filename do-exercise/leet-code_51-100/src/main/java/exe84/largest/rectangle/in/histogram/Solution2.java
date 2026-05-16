package exe84.largest.rectangle.in.histogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 第 84 题「柱状图中最大的矩形」（方案2）：单调递增栈，遇到更矮柱子时弹出并计算面积。
 */
class Solution2 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        heights = Arrays.copyOf(heights, heights.length + 1);
        int i = 0;
        int maxArea = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int x = stack.pop();
                if (stack.isEmpty()) {
                    maxArea = Math.max(maxArea, i * heights[x]);
                } else {
                    maxArea = Math.max(maxArea, (i - stack.peek() - 1) * heights[x]);
                }
            }
        }
        return maxArea;
    }
}