package manfred.exercises.leetcode.p1281;

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
