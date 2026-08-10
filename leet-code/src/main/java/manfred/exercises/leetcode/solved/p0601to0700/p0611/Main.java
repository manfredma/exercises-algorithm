package manfred.exercises.leetcode.solved.p0601to0700.p0611;

/** 题目链接：https://leetcode.cn/problems/valid-triangle-number/ */

/*
给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。

示例 1:

输入: nums = [2,2,3,4]
输出: 3
解释:有效的组合是:
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3

示例 2:

输入: nums = [4,2,3,4]
输出: 4

提示:

1 <= nums.length <= 1000

0 <= nums[i] <= 1000
*/
/** LeetCode 第 611 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        assertEquals(3, solution.triangleNumber(new int[]{2, 2, 3, 4}));
        assertEquals(4, solution.triangleNumber(new int[]{4, 2, 3, 4}));
        assertEquals(0, solution.triangleNumber(new int[]{0, 0, 1, 1}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
