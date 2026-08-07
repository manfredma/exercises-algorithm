package manfred.exercises.leetcode.solved.p0201to0300.p0260;

class Solution {
    public int[] singleNumber(int[] nums) {
        // 全部异或，获取两个不同值的 a^b
        int xorOfSingles = 0;
        for (int num : nums) {
            xorOfSingles ^= num;
        }

        // 获取两个不同值其中不同的那一位
        int bit = xorOfSingles & (-xorOfSingles);

        // 分成两组，其中一组的bit位为 1，一组为 0
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & bit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
