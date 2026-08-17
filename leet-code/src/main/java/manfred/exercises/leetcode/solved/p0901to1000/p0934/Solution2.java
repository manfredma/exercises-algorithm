package manfred.exercises.leetcode.solved.p0901to1000.p0934;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean foundFirstIsland = false;

        for (int row = 0; row < grid.length && !foundFirstIsland; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    markFirstIsland(grid, row, column, queue);
                    foundFirstIsland = true;
                    break;
                }
            }
        }

        int flips = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int[] cell = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int nextRow = cell[0] + direction[0];
                    int nextColumn = cell[1] + direction[1];
                    if (nextRow < 0 || nextRow >= grid.length
                            || nextColumn < 0 || nextColumn >= grid[0].length
                            || grid[nextRow][nextColumn] == -1) {
                        continue;
                    }
                    if (grid[nextRow][nextColumn] == 1) {
                        return flips;
                    }
                    grid[nextRow][nextColumn] = -1;
                    queue.offer(new int[]{nextRow, nextColumn});
                }
            }
            flips++;
        }
        return -1;
    }

    private void markFirstIsland(int[][] grid, int row, int column, Deque<int[]> queue) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, column});
        grid[row][column] = -1;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            queue.offer(cell);
            for (int[] direction : DIRECTIONS) {
                int nextRow = cell[0] + direction[0];
                int nextColumn = cell[1] + direction[1];
                if (nextRow < 0 || nextRow >= grid.length
                        || nextColumn < 0 || nextColumn >= grid[0].length
                        || grid[nextRow][nextColumn] != 1) {
                    continue;
                }
                grid[nextRow][nextColumn] = -1;
                stack.push(new int[]{nextRow, nextColumn});
            }
        }
    }
}
