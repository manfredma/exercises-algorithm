package manfred.exercises.leetcode.p1035;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 这是一个最长公共子序列的问题，因为只有公共子序列才能不相交，否则就会因顺序不一致而相交。
        // 声明如下数组，表示从两个元素中各取前缀长度的子串其形成的最长公共子序列，因为 0 长度的值
        // 递推表达式：如果最后一个元素相等，则其最长公共子序列=长度同时-1的子序列，否则等于其中一个长度-1的公共子序列中的大值，因为最后一个元素无效。
        int[][] longestCommon = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    longestCommon[i][j] = longestCommon[i - 1][j - 1] + 1;
                } else {
                    longestCommon[i][j] = Math.max(longestCommon[i][j - 1], longestCommon[i - 1][j]);
                }
            }
        }
        return longestCommon[nums1.length][nums2.length];
    }
}
