package manfred.exercises.leetcode.solved.p0201to0300.p0240;

/**
 * 搜索二维矩阵 II —— 逐行二分 + 右边界收缩解法。
 *
 * <p>思路：对每一行做二分查找。利用列升序性质——上一行二分确定的右边界 right，
 * 下一行可直接复用（下方行的同列值更大，right 之后的列必然也大于 target），
 * 从而右边界单调左移，避免每行都从行尾重新二分。
 *
 * <p>复杂度：时间 O(m log n)，每行二分且右边界收缩；空间 O(1)。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 找到或找到可能所在的行, 找第一个大于当前值的元素
        int left, right = matrix[0].length;
        for (int[] ints : matrix) {
            // 右侧因为都是递增，之后的循环可以在上一行的右侧基础上进行
            left = 0;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
