package manfred.exercises.leetcode.p0746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, prePre = 0, cur = 0;
        for (int i = 2; i <= cost.length; i++) {
            cur = Math.min(pre + cost[i - 1], prePre + cost[i - 2]);
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
