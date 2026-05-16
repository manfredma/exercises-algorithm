package manfred.exercises.leetcode.p134;

/**
 * LeetCode 第 134 题「加油站」：贪心法，当总油量>=总耗油量时必有解，从总油量首次非负处出发。
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) {
            return -1;
        }
        int begin = -1;
        int left = -1;
        int totalLeft = 0;

        for (int i = 0; i < gas.length; i++) {
            if (left < 0) {
                begin = i;
                left = 0;
            }
            totalLeft += gas[i] - cost[i];
            left += gas[i] - cost[i];
        }

        if (totalLeft < 0) {
            return -1;
        }

        // 补充计算前半段
        for (int i = 0; i < begin; i++) {
            left += gas[i] - cost[i];
            if (left < 0) {
                return -1;
            }
        }

        return begin;
    }
}