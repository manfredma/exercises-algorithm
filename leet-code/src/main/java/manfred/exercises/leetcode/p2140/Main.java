package manfred.exercises.leetcode.p2140;

/*
给你一个下标从 0 开始的二维整数数组 questions，其中 questions[i] = [pointsi, brainpoweri]。
按顺序处理每个问题，选择解决或跳过。解决问题 i 获得 pointsi 分，但无法解决接下来 brainpoweri 个问题；跳过则可处理下一个。
返回能获得的最高分数。

示例 1:
输入：questions = [[3,2],[4,3],[4,4],[2,5]]
输出：5

示例 2:
输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
输出：7
*/
/**
 * LeetCode 第 2140 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 questions = [[3,2],[4,3],[4,4],[2,5]] → 期望 5
        System.out.println(solution.mostPoints(
                new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
        // 示例 2: 输入 questions = [[1,1],[2,2],[3,3],[4,4],[5,5]] → 期望 7
        System.out.println(solution.mostPoints(
                new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }
}
