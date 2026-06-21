package manfred.exercises.leetcode.p0901;

/*
设计一个算法收集某些股票的每日报价，并返回该股票当日价格的跨度。
当日跨度 = 股票价格小于或等于今天价格的最大连续日数（从今天往回数，包括今天）。

示例：
输入：["StockSpanner","next","next","next","next","next","next","next"]
      [[], [100], [80], [60], [70], [60], [75], [85]]
输出：[null, 1, 1, 1, 2, 1, 4, 6]

提示：
- 1 <= price <= 10^5
- 最多调用 next 方法 10^4 次
*/
/**
 * LeetCode 第 901 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 期望 1
        System.out.println(stockSpanner.next(80));  // 期望 1
        System.out.println(stockSpanner.next(60));  // 期望 1
        System.out.println(stockSpanner.next(70));  // 期望 2
        System.out.println(stockSpanner.next(60));  // 期望 1
        System.out.println(stockSpanner.next(75));  // 期望 4
        System.out.println(stockSpanner.next(85));  // 期望 6
    }
}
