package manfred.exercises.leetcode.p0289;

class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (countLivesNeighbor(board, i, j) == 2 || countLivesNeighbor(board, i, j) == 3) {
                        board[i][j] |= 1 << 1;
                    }
                } else {
                    if (countLivesNeighbor(board, i, j) == 3) {
                        board[i][j] |= 1 << 1;
                    }
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
        if (i - 1 >= 0) {
            lived += board[i - 1][j] & 1;
            if (j - 1 >= 0) {
                lived += board[i - 1][j - 1] & 1;
            }
            if (j + 1 < board[i].length) {
                lived += board[i - 1][j + 1] & 1;
            }
        }
        if (j - 1 >= 0) {
            lived += board[i][j - 1] & 1;
        }
        if (j + 1 < board[i].length) {
            lived += board[i][j + 1] & 1;
        }

        if (i + 1 < board.length) {
            lived += board[i + 1][j] & 1;
            if (j - 1 >= 0) {
                lived += board[i + 1][j - 1] & 1;
            }
            if (j + 1 < board[i].length) {
                lived += board[i + 1][j + 1] & 1;
            }
        }

        return lived;
    }
}
