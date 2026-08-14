package manfred.exercises.leetcode.solved.p0001to0100.p0084;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 第 84 题「柱状图中最大的矩形」（方案 3）：与方案 2 同样维护单调递增栈，
 * 但通过遍历到 {@code heights.length} 时虚拟一个高度为 0 的柱子来清空栈，因此不复制输入数组。
 *
 * <p>每根柱子至多入栈、出栈一次，时间复杂度为 O(n)，空间复杂度为 O(n)。</p>
 */
class Solution3 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int idx = 0; idx <= heights.length;) {
            int curHeight = (idx == heights.length ? 0 : heights[idx]);
            if (stack.isEmpty() || curHeight > heights[stack.peek()]) {
                stack.push(idx++);
            } else {
                // 碰到比栈顶矮的元素了，这样就可以计算以"栈顶元素"为高的面积了。
                int heightIdx = stack.pop();
                int len = idx - (stack.isEmpty() ? -1 : stack.peek()) - 1;
                maxArea = Math.max(maxArea, heights[heightIdx] * len);
            }
        }
        return maxArea;
    }
}
