package manfred.exercises.leetcode.p1926;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // 找最短路径使用 BFS 来探索。
        int rowSize = maze.length;
        int columnSize = maze[0].length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[rowSize][columnSize];
        visited[entrance[0]][entrance[1]] = true;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] coordinate = queue.poll();
                for (int[] direction : directions) {
                    int[] newCoordinate = new int[]{coordinate[0] + direction[0], coordinate[1] + direction[1]};
                    if (!isValidCoordinate(newCoordinate, rowSize, columnSize)) {
                        continue;
                    }
                    if (maze[newCoordinate[0]][newCoordinate[1]] == '+') {
                        // 是墙，不需要再探测
                        continue;
                    }
                    if (visited[newCoordinate[0]][newCoordinate[1]]) {
                        // 已经访问过，不需要再探测
                        continue;
                    }
                    if (isExit(newCoordinate, rowSize, columnSize)) {
                        return step;
                    }
                    // 标记一下当前节点已经探测过了
                    visited[newCoordinate[0]][newCoordinate[1]] = true;
                    queue.offer(newCoordinate);
                }
            }
        }
        return -1;
    }

    private boolean isValidCoordinate(int[] coordinate, int rowSize, int columnSize) {
        return coordinate[0] >= 0 && coordinate[0] < rowSize && coordinate[1] >= 0 && coordinate[1] < columnSize;
    }

    private boolean isExit(int[] coordinate, int rowSize, int columnSize) {
        return coordinate[0] == 0 || coordinate[1] == 0 || coordinate[0] == rowSize - 1 || coordinate[1] == columnSize - 1;
    }
}
