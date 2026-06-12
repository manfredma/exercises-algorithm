package manfred.exercises.leetcode.p0994;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[grid.length * grid[0].length];
        int maxBfs = bfs(grid, visited);
        for (int i = 0; i < visited.length; i++) {
            // 如果存在新鲜橘子没有被腐蚀到，则返回-1
            if (!visited[i] && grid[i / grid[0].length][i % grid[0].length] == 1) {
                return -1;
            }
        }

        return maxBfs;
    }

    private int bfs(int[][] grid, boolean[] visited) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (grid[i / grid[0].length][i % grid[0].length] == 2) {
                queue.add(new int[]{i, 0});
                visited[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] visitedElement = queue.poll();
            result = visitedElement[1]; // 广度优先算法，最后弹出的元素就是最后被访问的
            int row = visitedElement[0] / grid[0].length;
            int column = visitedElement[0] % grid[0].length;
            tryVisit(grid, visited, row, column - 1, visitedElement[1], queue);
            tryVisit(grid, visited, row, column + 1, visitedElement[1], queue);
            tryVisit(grid, visited, row - 1, column, visitedElement[1], queue);
            tryVisit(grid, visited, row + 1, column, visitedElement[1], queue);
        }
        return result;
    }

    private void tryVisit(int[][] grid, boolean[] visited, int row, int column, int depth, Queue<int[]> queue) {
        if (isValidIndex(grid, row, column) // 合法坐标：没有跳出矩阵之外！
                && grid[row][column] > 0 // 这个节点有橘子
                && !visited[row * grid[0].length + column] // 这个节点的橘子没有被访问过！
        ) {
            queue.add(new int[]{row * grid[0].length + column, depth + 1});
            visited[row * grid[0].length + column] = true;
        }
    }

    private boolean isValidIndex(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
