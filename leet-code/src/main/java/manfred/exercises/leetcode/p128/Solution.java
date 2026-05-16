package manfred.exercises.leetcode.p128;

import java.util.HashMap;

/**
 * LeetCode 第 128 题「最长连续序列」：哈希集合，从每段的起点开始向后延伸计数。
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> n = new HashMap<>(nums.length);
        int r = 0;
        for (int num : nums) {
            if (n.containsKey(num)) {
                continue;
            }

            int left = n.getOrDefault(num - 1, 0);
            int right = n.getOrDefault(num + 1, 0);
            int sum = left + right + 1;

            n.put(num - left, sum);
            n.put(num + right, sum);
            // 加入number 是为了防止同 num 再进来
            n.put(num, sum);

            r = Math.max(r, sum);
        }
        return r;
    }
}