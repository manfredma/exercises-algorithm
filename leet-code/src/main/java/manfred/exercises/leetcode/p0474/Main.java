package manfred.exercises.leetcode.p0474;

/*
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

示例 1：
输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4

示例 2：
输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
*/
/**
 * LeetCode 第 474 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 strs = ["10","0001","111001","1","0"], m = 5, n = 3 → 期望 4
        System.out.println(solution.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        // 示例 2: 输入 strs = ["10","0","1"], m = 1, n = 1 → 期望 2
        System.out.println(solution.findMaxForm(
                new String[]{"10", "0", "1"}, 1, 1));
        // 示例 3: 输入 strs = ["10"], m = 2, n = 2 → 期望 1
        System.out.println(solution.findMaxForm(
                new String[]{"10"}, 2, 2));
    }
}
