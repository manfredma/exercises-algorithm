package manfred.exercises.leetcode.p1218;

/*
给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，
该子序列中相邻元素之间的差等于 difference。

子序列是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

示例 1：
输入：arr = [1,2,3,4], difference = 1
输出：4

示例 2：
输入：arr = [1,3,5,7], difference = 1
输出：1

示例 3：
输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
输出：4

提示：
1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
*/
/**
 * LeetCode 第 1218 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: arr=[1,2,3,4], difference=1 → 期望 4
        System.out.println(solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));

        // 示例 2: arr=[1,3,5,7], difference=1 → 期望 1
        System.out.println(solution.longestSubsequence(new int[]{1, 3, 5, 7}, 1));

        // 示例 3: arr=[1,5,7,8,5,3,4,2,1], difference=-2 → 期望 4
        System.out.println(solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
