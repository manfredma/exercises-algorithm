package manfred.exercises.leetcode.p1275;

class Solution {
        public String tictactoe(int[][] moves) {
            int[] rows = new int[3], cols = new int[3];
            int diag = 0, anti = 0;
            int player = 1; // A=+1, B=-1

            for (int[] move : moves) {
                int r = move[0], c = move[1];
                rows[r] += player;
                cols[c] += player;
                if (r == c)     diag += player;
                if (r + c == 2) anti += player;

                if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3
                        || Math.abs(diag) == 3 || Math.abs(anti) == 3) {
                    return player == 1 ? "A" : "B";
                }
                player = -player;
            }

            return moves.length == 9 ? "Draw" : "Pending";
        }
}
