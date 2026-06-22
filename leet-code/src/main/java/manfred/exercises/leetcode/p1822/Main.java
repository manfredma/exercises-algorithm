package manfred.exercises.leetcode.p1822;

/*
signFunc(x)：x>0 返回 1，x<0 返回 -1，x=0 返回 0。
给你整数数组 nums，返回 signFunc(所有元素之积)。

示例 1：
输入：nums = [-1,-2,-3,-4,3,2,1]
输出：1

示例 2：
输入：nums = [1,5,0,2,-3]
输出：0

示例 3：
输入：nums = [-1,1,-1,1,-1]
输出：-1

提示：
- 1 <= nums.length <= 1000
- -100 <= nums[i] <= 100
*/
/**
 * LeetCode 第 1822 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: [-1,-2,-3,-4,3,2,1] → 期望 1
        System.out.println(solution.arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        // 示例 2: [1,5,0,2,-3] → 期望 0
        System.out.println(solution.arraySign(new int[]{1, 5, 0, 2, -3}));
        // 示例 3: [-1,1,-1,1,-1] → 期望 -1
        System.out.println(solution.arraySign(new int[]{-1, 1, -1, 1, -1}));
    }
}
