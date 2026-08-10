package manfred.exercises.leetcode.solved.p1201to1300.p1281;

/** 题目链接：https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/ */

/*
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
*/
/**
 * LeetCode 第 1281 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 234 → 期望 15
        System.out.println(solution.subtractProductAndSum(234));
        // 示例 2: n = 4421 → 期望 21
        System.out.println(solution.subtractProductAndSum(4421));
    }
}
