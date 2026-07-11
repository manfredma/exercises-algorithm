package manfred.exercises.leetcode.p0547;

/**
 * 并查集（Union-Find）解法。
 *
 * <p>思路：每个城市初始自成一组，遍历邻接矩阵的上三角（利用对称性避免重复），
 * 把相连的城市 union 起来。最终不同根节点的数量即为省份数量。
 *
 * <p>采用「按秩合并 + 路径压缩」优化，单次操作近似 O(α(n))，整体近似 O(n²)。
 */
class Solution3 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // 只遍历上三角：isConnected 对称，i<j 即可
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, rank, i, j);
                }
            }
        }

        int circlesNum = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                circlesNum++;
            }
        }
        return circlesNum;
    }

    /** 路径压缩：查找根节点，并把路径上的节点直接挂到根上。 */
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    /** 按秩合并：把矮树挂到高树下，避免树退化成链。 */
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
