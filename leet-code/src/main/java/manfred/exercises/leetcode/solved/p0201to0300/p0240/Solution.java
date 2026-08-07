package manfred.exercises.leetcode.solved.p0201to0300.p0240;

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
