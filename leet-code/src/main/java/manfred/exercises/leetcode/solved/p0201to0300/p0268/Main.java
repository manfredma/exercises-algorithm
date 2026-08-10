package manfred.exercises.leetcode.solved.p0201to0300.p0268;

/** 题目链接：https://leetcode.cn/problems/missing-number/ */

/*
给定一个包含 [0, n] 中 n 个数的数组 nums，找出 [0, n] 这个范围内没有出现在数组中的那个数。

示例 1：
输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字。

示例 2：
输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字。

示例 3：
输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字。

提示：
n == nums.length
1 <= n <= 10^4
0 <= nums[i] <= n
nums 中的所有数字都独一无二。

进阶：你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题？
*/
/** LeetCode 第 268 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, solution.missingNumber(new int[]{0, 1}));
        assertEquals(8, solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("期望：" + expected + "，实际：" + actual);
        }
        System.out.println("通过：" + expected);
    }
}
