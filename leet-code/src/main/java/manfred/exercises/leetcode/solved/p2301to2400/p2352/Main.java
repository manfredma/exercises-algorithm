package manfred.exercises.leetcode.solved.p2301to2400.p2352;

/** 题目链接：https://leetcode.cn/problems/equal-row-and-column-pairs/ */

/*
给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Rᵢ 行和 Cⱼ 列相等的行列对 (Rᵢ, Cⱼ) 的数目。

如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。



示例 1：

输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
输出：1
解释：存在一对相等行列对：
- (第 2 行，第 1 列)：[2,7,7]

示例 2：

输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
输出：3
解释：存在三对相等行列对：
- (第 0 行，第 0 列)：[3,1,2,2]
- (第 2 行, 第 2 列)：[2,4,2,2]
- (第 3 行, 第 2 列)：[2,4,2,2]



提示：


n == grid.length == grid[i].length


1 <= n <= 200


1 <= grid[i][j] <= 10^5
*/
/** LeetCode 第 2352 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        assertEquals(1, solution.equalPairs(new int[][] {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        assertEquals(1, solution2.equalPairs(new int[][] {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}));
        assertEquals(
                3,
                solution.equalPairs(
                        new int[][] {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
        assertEquals(
                3,
                solution2.equalPairs(
                        new int[][] {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}));
        assertEquals(1, solution.equalPairs(new int[][] {{1}}));
        assertEquals(1, solution2.equalPairs(new int[][] {{1}}));
        assertEquals(0, solution.equalPairs(new int[][] {{1, 2}, {3, 4}}));
        assertEquals(0, solution2.equalPairs(new int[][] {{1, 2}, {3, 4}}));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError();
    }
}
