package manfred.exercises.leetcode.p0547;

/**
 * 深度优先搜索解法。
 *
 * <p>思路：把 isConnected 视为无向图的邻接矩阵。逐个遍历城市 i，
 * 若 i 未被访问，则以其为起点做一次 DFS，把与 i 直接或间接相连的城市全部标记，
 * 这些城市构成一个省份。DFS 的启动次数即为省份数量。
 */
class Solution2 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int circlesNum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(isConnected, visited, i);
            circlesNum++;
        }
        return circlesNum;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
