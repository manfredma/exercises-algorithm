package manfred.exercises.leetcode.p0983;

/*
在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
你要旅行的日子以 days 数组给出，火车票有 1 天、7 天、30 天三种通行证，售价分别为 costs[0]、costs[1]、costs[2]。
返回完成 days 中列出的每一天旅行所需的最低消费。

示例 1:
输入：days = [1,4,6,7,8,20], costs = [2,7,15]
输出：11

示例 2:
输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
输出：17
*/
/**
 * LeetCode 第 983 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 days = [1,4,6,7,8,20], costs = [2,7,15] → 期望 11
        System.out.println(solution.mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        // 示例 2: 输入 days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15] → 期望 17
        System.out.println(solution.mincostTickets(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));
    }
}
