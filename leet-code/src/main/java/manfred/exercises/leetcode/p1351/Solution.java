package manfred.exercises.leetcode.p1351;

class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;

        int len = grid.length;
        int start = 0, end = grid[0].length - 1;
        for (int i = 0; i < len; i++) {
            int insertIdx = binarySearch0(grid[i], start, end);
            result += grid[i].length - insertIdx;
            // 这个地方实际上可以优化一下，按列也是递减的，那么后面再搜索的时候，就不需要再搜索前面的部分了吧？
            end = insertIdx - 1;
        }

        return result;
    }

    // 这个位置是 0 插入的坐标
    private int binarySearch0(int[] x, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (x[mid] < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
