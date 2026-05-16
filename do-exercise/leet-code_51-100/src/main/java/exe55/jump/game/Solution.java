package exe55.jump.game;

/**
 * LeetCode 第 55 题「跳跃游戏」：贪心法维护最远可达位置，判断是否能到达末尾。
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int maxI = i + nums[i];
            if (maxI > max) {
                max = maxI;
            }
            if (max >= nums.length - 1) {
                return true;
            }
            if (max == i) {
                return false;
            }
        }
        return false;
    }
}