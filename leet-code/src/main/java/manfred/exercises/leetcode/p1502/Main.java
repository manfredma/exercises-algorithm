package manfred.exercises.leetcode.p1502;

/*
给你一个数字数组 arr，如果可以重新排列数组形成等差数列，返回 true，否则返回 false。

示例 1：
输入：arr = [3,5,1]
输出：true

示例 2：
输入：arr = [1,2,4]
输出：false

提示：
- 2 <= arr.length <= 1000
- -10^6 <= arr[i] <= 10^6
*/
/**
 * LeetCode 第 1502 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: arr = [3,5,1] → 期望 true
        System.out.println(solution.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        // 示例 2: arr = [1,2,4] → 期望 false
        System.out.println(solution.canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}
