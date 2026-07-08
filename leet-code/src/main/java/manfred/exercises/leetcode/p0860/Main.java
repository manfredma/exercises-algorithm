package manfred.exercises.leetcode.p0860;

/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，
（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

给你一个整数数组 bills，其中 bills[i] 是第 i 位顾客付的账。
如果你能给每位顾客正确找零，返回 true，否则返回 false。
*/
/**
 * LeetCode 第 860 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: bills = [5,5,5,10,20] → 期望 true
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));

        // 示例 2: bills = [5,5,10,10,20] → 期望 false
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
