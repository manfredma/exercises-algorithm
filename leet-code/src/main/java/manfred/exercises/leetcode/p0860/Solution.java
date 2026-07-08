package manfred.exercises.leetcode.p0860;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 20 元是最大面额，无法用于找零，只需跟踪 5 元、10 元张数
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 找零 5 元
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                // 找零 15 元：优先用 10 元（10 元用途单一，5 元是万能零钱更该保留）
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
