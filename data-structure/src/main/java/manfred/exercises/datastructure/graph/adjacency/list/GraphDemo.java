package manfred.exercises.datastructure.graph.adjacency.list;

/**
 * 邻接表图结构演示：演示 BFS 广度优先搜索和 DFS 深度优先搜索在图上的遍历路径。
 */
public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0, 6);

        System.out.println();
        graph.dfs(0, 6);
        System.out.println();
        graph.dfs(0, 7);

        System.out.println();
        graph.dfs2(0, 6);
        System.out.println();
        graph.dfs2(0, 7);
    }
}
