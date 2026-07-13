package manfred.exercises.leetcode.p0518;

class Solution {
    public int change(int amount, int[] coins) {
        // 可以组合的数量：固定其中一个硬币的数量为 0，1， 2， 3...， 然后求其他组合的数量，然后相加即可，可以先用递归实现一下试试
        return tryChange(amount, coins, 0);
    }

    private int tryChange(int amount, int[] coins, int start) {
        if (amount == 0) {
            return 1;
        }
        // 如果是最后一个硬币，则没有必要继续计算
        if (start == coins.length - 1) {
            return amount % coins[start] == 0 ? 1 : 0;
        }

        int result = 0;
        // 尝试固定其中一个数值
        for (int i = 0; i * coins[start] <= amount; i++) {
            result += tryChange(amount - i * coins[start], coins, start + 1);
        }
        return result;
    }
}
