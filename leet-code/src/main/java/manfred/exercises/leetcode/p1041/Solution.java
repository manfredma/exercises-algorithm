package manfred.exercises.leetcode.p1041;

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int[] direction = new int[]{0, 1};
        for (int i = 0; i < instructions.length(); i++) {
            int tmp = direction[0];
            switch (instructions.charAt(i)) {
                case 'G':
                    x = x + direction[0];
                    y = y + direction[1];
                    break;
                case 'L':
                    direction[0] = -direction[1];
                    direction[1] = tmp;
                    break;
                case 'R':
                    direction[0] = direction[1];
                    direction[1] = -tmp;
            }
        }
        return (x == 0 && y == 0) || direction[1] != 1;
    }
}
