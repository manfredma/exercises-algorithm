package manfred.exercises.leetcode.solved.p1301to1400.p1306;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/jump-game-iii/ */

/*
给定一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。

请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。

注意，不管是什么情况下，你都无法跳到数组之外。

示例 1：

输入：arr = [4,2,3,0,3,1,2], start = 5
输出：true
解释：
到达值为 0 的下标 3 有以下可能方案：
下标 5 -> 下标 4 -> 下标 1 -> 下标 3
下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3

示例 2：

输入：arr = [4,2,3,0,3,1,2], start = 0
输出：true
解释：
到达值为 0 的下标 3 有以下可能方案：
下标 0 -> 下标 4 -> 下标 1 -> 下标 3

示例 3：

输入：arr = [3,0,2,1,2], start = 2
输出：false
解释：无法到达值为 0 的下标 1 处。

提示：

1 <= arr.length <= 5 * 10^4

0 <= arr[i] < arr.length

0 <= start < arr.length
 */
/**
 * LeetCode 第 1306 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(true, solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        assertEquals(true, solution.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
        assertEquals(false, solution.canReach(new int[]{3, 0, 2, 1, 2}, 2));
        assertEquals(true, solution.canReach(new int[]{0}, 0));
        assertEquals(false, solution.canReach(new int[]{1, 1}, 0));
    }

}
