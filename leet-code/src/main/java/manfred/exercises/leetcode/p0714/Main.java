package manfred.exercises.leetcode.p0714;

/*
给定一个整数数组 prices，其中 prices[i] 表示第 i 天的股票价格；整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。
如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
*/
/**
 * LeetCode 第 714 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: prices = [1, 3, 2, 8, 4, 9], fee = 2 → 期望 8
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        // 示例 2: prices = [1,3,7,5,10,3], fee = 3 → 期望 6
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
