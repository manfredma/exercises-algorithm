package exe200.number.of.islands;

/**
 * LeetCode 第 200 题「岛屿数量」：DFS/BFS 将访问过的陆地标记，统计连通分量数。
 */
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    mark(grid, i, j);
                }
            }
        }
        return result;

    }

    private void mark(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        boolean update;
        do {
            update = false;
            for (int k = i; k < grid.length; k++) {
                for (int l = 0; l < grid[0].length; l++) {
                    if (grid[k][l] == '1') {
                        if (k > 0) {
                            if (grid[k - 1][l] == '2') {
                                grid[k][l] = '2';
                            }
                        }
                        if (k != grid.length - 1) {
                            if (grid[k + 1][l] == '2') {
                                grid[k][l] = '2';
                            }
                        }
                        if (l > 0) {
                            if (grid[k][l - 1] == '2') {
                                grid[k][l] = '2';
                            }
                        }
                        if (l != grid[0].length - 1) {
                            if (grid[k][l + 1] == '2') {
                                grid[k][l] = '2';
                            }
                        }

                        if (grid[k][l] == '2') {
                            update = true;
                        }
                    }
                }
            }
        } while (update);
    }
}