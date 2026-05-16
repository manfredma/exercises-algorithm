package exe174.dungeon.game;

/**
 * LeetCode 第 174 题「地下城游戏」：动态规划从右下到左上逆推，维护最低生命值。
 */
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 1;
        }
        if (dungeon[0].length == 0) {
            return 1;
        }

        int[][] beforeHealth = new int[dungeon.length][dungeon[0].length];
        for (int i = beforeHealth.length - 1; i >= 0; i--) {
            for (int j = beforeHealth[i].length - 1; j >= 0; j--) {
                if (i == beforeHealth.length - 1 && j == beforeHealth[i].length - 1) {
                    // 最后一个元素
                    if (dungeon[i][j] > 0) {
                        beforeHealth[i][j] = 1;
                    } else {
                        beforeHealth[i][j] = -dungeon[i][j] + 1;
                    }
                } else if (i == beforeHealth.length - 1) {
                    int left = beforeHealth[i][j + 1];
                    if (dungeon[i][j] >= left) {
                        beforeHealth[i][j] = 1;
                    } else {
                        beforeHealth[i][j] = left - dungeon[i][j];
                    }
                } else if (j == beforeHealth[i].length - 1) {
                    int left = beforeHealth[i + 1][j];
                    if (dungeon[i][j] >= left) {
                        beforeHealth[i][j] = 1;
                    } else {
                        beforeHealth[i][j] = left - dungeon[i][j];
                    }
                } else {
                    int left = Math.min(beforeHealth[i + 1][j], beforeHealth[i][j + 1]);
                    if (dungeon[i][j] >= left) {
                        beforeHealth[i][j] = 1;
                    } else {
                        beforeHealth[i][j] = left - dungeon[i][j];
                    }
                }
            }
        }

        return beforeHealth[0][0];
    }
}