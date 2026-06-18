package manfred.exercises.leetcode.p0427;

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int x, int y, int length) {

        Node node = new Node();
        boolean[] seen = new boolean[2];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                seen[grid[i][j]] = true;
            }
        }
        if (seen[0] && seen[1]) {
            node.isLeaf = false;
            // 这个可以随便设置 -- 下面的值并不是全部相同，则可以设置为任意值
            node.val = true;
            int subLength = length / 2;
            node.topLeft = construct(grid, x, y, subLength);
            node.topRight = construct(grid, x, y + subLength, subLength);
            node.bottomLeft = construct(grid, x + subLength, y, subLength);
            node.bottomRight = construct(grid, x + subLength, y + subLength, subLength);
        } else if (seen[0]) {
            node.isLeaf = true;
            node.val = false;
        } else {
            node.isLeaf = true;
            node.val = true;
        }
        return node;
    }
}
