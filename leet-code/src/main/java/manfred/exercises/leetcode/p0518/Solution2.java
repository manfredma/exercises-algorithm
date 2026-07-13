package manfred.exercises.leetcode.p0518;

class Solution2 {
    public int change(int amount, int[] coins) {
        // 行向量表示硬币的种类，列表示需要组合的金额（需要有 0 来表示组成 0 的方式只有一种），其中的值表示存在的组合数
        // 递推表达式：选择当前的硬币种类+金额时，其值等于
        int[][] change = new int[coins.length][amount + 1];
        // 初始化一下只有一个硬币的情况
        for (int i = 0; i <= amount; i++) {
            change[0][i] = (i % coins[0] == 0 ? 1 : 0);
        }
        // 从第二个货币面额开始就需要关注前面的组合数是多少了
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k <= j; k += coins[i]) {
                    change[i][j] += change[i - 1][j - k];
                }
            }
        }
        return change[coins.length - 1][amount];
    }
}
