package manfred.exercises.leetcode.solved.p0901to1000.p0934;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestBridge(int[][] grid) {
        // 这个题目适合使用广度优先搜索来完成探索，初步需要探索一下当前其中一个岛的所有元素作为出发点
        int rowLen = grid.length;
        int columnLen = grid[0].length;

        // 找一个为 1 的点(坐标)即可
        int[] coordinate = new int[2];
        boolean found = false;
        for (int i = 0; i < rowLen; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j] == 1) {
                    coordinate[0] = i;
                    coordinate[1] = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // 把这个岛屿的所有坐标都识别出来，广度优先
        boolean[][] visited = new boolean[rowLen][columnLen];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(coordinate);
        Deque<int[]> queue2 = new ArrayDeque<>();
        queue2.offer(coordinate);
        visited[coordinate[0]][coordinate[1]] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int[] direction : directions) {
                int[] newXy = new int[]{xy[0] + direction[0], xy[1] + direction[1]};
                if (newXy[0] >= 0 && newXy[0] < rowLen && newXy[1] >= 0 && newXy[1] < columnLen) {
                    // 合法坐标
                    if (!visited[newXy[0]][newXy[1]] && grid[newXy[0]][newXy[1]] == 1) {
                        queue.offer(newXy);
                        queue2.offer(newXy);
                        visited[newXy[0]][newXy[1]] = true;
                    }
                }
            }
        }
        int result = 0;

        while (!queue2.isEmpty()) {
            int levelSize = queue2.size();
            for (int i = 0; i < levelSize; i++) {
                int[] xy = queue2.poll();
                for (int[] direction : directions) {
                    int[] newXy = new int[]{xy[0] + direction[0], xy[1] + direction[1]};
                    if (newXy[0] >= 0 && newXy[0] < rowLen && newXy[1] >= 0 && newXy[1] < columnLen) {
                        // 合法坐标
                        if (!visited[newXy[0]][newXy[1]]) {
                            queue2.offer(newXy);
                            visited[newXy[0]][newXy[1]] = true;
                        } else {
                            continue;
                        }
                        if (grid[newXy[0]][newXy[1]] == 1) {
                            // 找到了第二个岛屿
                            return result;
                        }
                    }
                }
            }
            result++;
        }

        // 按照题目要求，肯定有两个岛屿，因此不会走到这里！
        return result;
    }
}
