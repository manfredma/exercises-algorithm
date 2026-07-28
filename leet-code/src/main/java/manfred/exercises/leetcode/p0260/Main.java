package manfred.exercises.leetcode.p0260;

import java.util.Arrays;

/*
给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
找出只出现一次的那两个元素。你可以按任意顺序返回答案。

你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。

示例 1：
输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5,3] 也是有效的答案。

示例 2：
输入：nums = [-1,0]
输出：[-1,0]

示例 3：
输入：nums = [0,1]
输出：[1,0]

提示：
2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
除两个只出现一次的整数外，nums 中的其他数字都出现两次。
*/
/** LeetCode 第 260 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        assertNumbers(new int[]{1, 2, 1, 3, 2, 5}, new int[]{3, 5});
        assertNumbers(new int[]{-1, 0}, new int[]{-1, 0});
        assertNumbers(new int[]{0, 1}, new int[]{1, 0});
    }

    private static void assertNumbers(int[] nums, int[] expected) {
        int[] actual = new Solution().singleNumber(nums);
        if (actual == null || actual.length != 2) {
            throw new AssertionError("期望返回两个数字");
        }
        Arrays.sort(actual);
        Arrays.sort(expected);
        if (!Arrays.equals(expected, actual)) {
            throw new AssertionError("期望：" + Arrays.toString(expected) + "，实际：" + Arrays.toString(actual));
        }
        System.out.println("通过：" + Arrays.toString(expected));
    }
}
