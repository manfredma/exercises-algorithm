package manfred.exercises.leetcode.p1493;

/*
给你一个二进制数组 nums ，你需要从中删掉一个元素。

请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。

如果不存在这样的子数组，请返回 0 。

提示 1：

输入：nums = [1,1,0,1]
输出：3
解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。

示例 2：

输入：nums = [0,1,1,1,0,1,1,0,1]
输出：5
解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。

示例 3：

输入：nums = [1,1,1]
输出：2
解释：你必须要删除一个元素。

提示：

1 <= nums.length <= 10^5
nums[i] 要么是 0 要么是 1 。
*/
/** LeetCode 第 1493 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertEquals(3, solution.longestSubarray(new int[]{1, 1, 0, 1}));
        assertEquals(5, solution.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        assertEquals(2, solution.longestSubarray(new int[]{1, 1, 1}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
