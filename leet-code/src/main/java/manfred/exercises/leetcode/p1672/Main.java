package manfred.exercises.leetcode.p1672;

/*
给你一个 m x n 的整数网格 accounts，其中 accounts[i][j] 是第 i 位客户在第 j 家银行
托管的资产数量。返回最富有客户所拥有的资产总量。

客户的资产总量就是他们在各家银行托管的资产数量之和。
最富有客户就是资产总量最大的客户。

示例 1：
输入：accounts = [[1,2,3],[3,2,1]]
输出：6

示例 2：
输入：accounts = [[1,5],[7,3],[3,5]]
输出：10

示例 3：
输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
输出：17

提示：
- m == accounts.length
- n == accounts[i].length
- 1 <= m, n <= 50
- 1 <= accounts[i][j] <= 100
*/

/**
 * LeetCode 第 1672 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: accounts = [[1,2,3],[3,2,1]] → 期望 6
        System.out.println(solution.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));

        // 示例 2: accounts = [[1,5],[7,3],[3,5]] → 期望 10
        System.out.println(solution.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));

        // 示例 3: accounts = [[2,8,7],[7,1,3],[1,9,5]] → 期望 17
        System.out.println(solution.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}
