package manfred.exercises.leetcode.solved.p0301to0400.p0334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second) {
                // second 已有一个在它之前且更小的元素与之配对，当前值可作为第三项。
                return true;
            } else if (nums[i] < first) {
                // 将第一项压低，为后续构造更小的第二项留下更多可能。
                first = nums[i];
            } else if (nums[i] > first && nums[i] < second) {
                // 更新为更小的第二项；此前形成的递增二元组仍是有效的历史证据。
                second = nums[i];
            }
        }
        return false;
    }
}
