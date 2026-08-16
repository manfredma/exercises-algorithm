package manfred.exercises.leetcode.solved.p0001to0100.p0004;

/**
 * LeetCode 第 4 题「寻找两个正序数组的中位数」：在较短数组上二分分割点。
 * 分割点 i 满足 nums1[i-1] <= nums2[j] 且 nums2[j-1] <= nums1[i]（j = half - i），
 * 边界用 MIN_VALUE/MAX_VALUE 哨兵处理；复杂度 O(log(min(m,n)))，达标解。
 */
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 思路：在两个有序数组上找分割点 i（nums1）、j（nums2），满足 i + j = half，
        // 且左半所有元素 <= 右半所有元素（即 nums1[i-1] <= nums2[j] 且 nums2[j-1] <= nums1[i]）。
        // 在较短数组上二分 i，复杂度 O(log(min(m,n)))。
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;
        // half 的左侧有 「(m + n + 1)/2」个点，如果是奇数个节点，则是右侧第一个节点。
        // 如果是偶数个节点，则是两个中位数节点中偏右侧的点。
        int half = (m + n + 1) / 2;
        int left = 0, right = m;

        while (left <= right) {
            // 针对小数组进行二分
            int i = (left + right) / 2;
            // 大数组的坐标满足相加为 half
            int j = half - i;
            // 如果找到了中位数点的话，那么 L1 < R2 && L2 < R1
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (L1 > R2) {
                // nums1 左侧划过头，分割点 i 需左移
                right = i - 1;
            } else if (L2 > R1) {
                // nums2 左侧划过头，等价于 i 偏小，需右移
                left = i + 1;
            } else {
                // 说明满足了 L1 < R2 && L2 < R1
                if ((m + n) % 2 == 1) {
                    // 总共奇数个节点，从 i 和 j 中取大值（升序排列）就是要找的中位数节点
                    return Math.max(L1, L2);
                } else {
                    // 总共偶数个节点，（m + n + 1）/ 2 指向的是中位数节点的右侧节点
                    // Math.min(R1, R2) 就是两个中位数节点中偏右的节点（大值）
                    // Math.max(L1, L2) 就是两个中位数节点中偏左的节点（小值）
                    return (Math.min(R1, R2) + Math.max(L1, L2))/ 2.0;
                }
            }
        }

        // 不会走到这里！
        return 0.0;
    }
}
