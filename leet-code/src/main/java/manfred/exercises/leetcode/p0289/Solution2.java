package manfred.exercises.leetcode.p0289;

class Solution2 {
    private static final int[][] DIRS = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = countLivesNeighbor(board, i, j);
                if (count == 3 || (count == 2 && board[i][j] == 1)) {
                    board[i][j] |= 1 << 1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int countLivesNeighbor(int[][] board, int i, int j) {
        int lived = 0;
        for (int[] d : DIRS) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                lived += board[ni][nj] & 1;
            }
        }
        return lived;
    }
}
