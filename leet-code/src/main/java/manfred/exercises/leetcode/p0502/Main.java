package manfred.exercises.leetcode.p0502;

/*
给你 n 个项目，每个项目有纯利润 profits[i] 和最小启动资本 capital[i]。
初始资本为 w，每完成一个项目利润加入资本，最多完成 k 个项目，求最大化最终资本。

示例 1：
输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
输出：4

示例 2：
输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
输出：6

提示：
- 1 <= k <= 10^5
- 0 <= w <= 10^9
- 1 <= n <= 10^5
- 0 <= profits[i] <= 10^4
- 0 <= capital[i] <= 10^9
*/
/**
 * LeetCode 第 502 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: k=2, w=0, profits=[1,2,3], capital=[0,1,1] → 期望 4
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        // 示例 2: k=3, w=0, profits=[1,2,3], capital=[0,1,2] → 期望 6
        System.out.println(solution.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
}
