package manfred.exercises.leetcode.solved.p0301to0400.p0347;

/** 题目链接：https://leetcode.cn/problems/top-k-frequent-elements/ */

import java.util.Arrays;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1：
输入：nums = [1,1,1,2,2,3], k = 2
输出：[1,2]

示例 2：
输入：nums = [1], k = 1
输出：[1]

示例 3：
输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2
输出：[1,2]

提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
*/
/**
 * LeetCode 第 347 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        int[] first = new int[] {1, 1, 1, 2, 2, 3};
        int[] second = new int[] {1};
        int[] third = new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        assertTopKEquals(new int[] {1, 2}, solution.topKFrequent(first, 2));
        assertTopKEquals(new int[] {1}, solution.topKFrequent(second, 1));
        assertTopKEquals(new int[] {1, 2}, solution.topKFrequent(third, 2));
        assertTopKEquals(new int[] {1, 2}, solution2.topKFrequent(first, 2));
        assertTopKEquals(new int[] {1}, solution2.topKFrequent(second, 1));
        assertTopKEquals(new int[] {1, 2}, solution2.topKFrequent(third, 2));
    }

    private static void assertTopKEquals(int[] expected, int[] actual) {
        Arrays.sort(actual);
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError(
                    "expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
        }
    }
}
