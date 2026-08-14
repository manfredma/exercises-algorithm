package manfred.exercises.leetcode.solved.p0001to0100.p0084;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 第 84 题「柱状图中最大的矩形」（方案 2）：在方案 1 的基础上使用单调递增栈。
 * 遇到较矮柱子时，弹出栈顶并以当前下标为右边界，计算该高度对应的最大面积；在数组末尾
 * 补充高度为 0 的哨兵，确保剩余柱子均被结算。
 *
 * <p>每个下标最多入栈、出栈一次，时间复杂度为 O(n)，空间复杂度为 O(n)。方案 3 使用
 * 不复制输入数组的等价哨兵写法。</p>
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
