package manfred.exercises.leetcode.p0036;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 第 36 题「有效的数独」：用哈希集合/位掩码分别验证行、列、3x3 宫格。
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> charactersRow = new HashSet<>();
        Set<Character> charactersColumn = new HashSet<>();
        Map<Integer, Set<Character>> character33 = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            character33.put(i, new HashSet<>());
        }

        // 每一行只能 1-9
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!charactersRow.add(board[i][j])) {
                        return false;
                    }
                    int index = i / 3 * 3 + j / 3;
                    if (!character33.get(index).add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!charactersColumn.add(board[j][i])) {
                        return false;
                    }
                }
            }
            charactersRow = new HashSet<>();
            charactersColumn = new HashSet<>();
        }
        return true;
    }
}