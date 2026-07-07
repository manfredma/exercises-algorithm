package manfred.exercises.leetcode.p0354;

/*
给你一个二维整数数组 envelopes，其中 envelopes[i] = [w_i, h_i]，
表示第 i 个信封的宽度和高度。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，
如同俄罗斯套娃一样。
请计算最多能有多少个信封能组成一组"俄罗斯套娃"信封。

注意：不允许旋转信封。

示例 1：
输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出：3

示例 2：
输入：envelopes = [[1,1],[1,1],[1,1]]
输出：1

提示：
- 1 <= envelopes.length <= 10^5
- envelopes[i].length == 2
- 1 <= w_i, h_i <= 10^5
*/
/**
 * LeetCode 第 354 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 [[5,4],[6,4],[6,7],[2,3]] → 期望 3
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        // 示例 2: 输入 [[1,1],[1,1],[1,1]] → 期望 1
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
    }
}
