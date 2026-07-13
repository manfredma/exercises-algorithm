package manfred.exercises.leetcode.p0258;

class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int add = 0;
        while (num > 0) {
            add += num % 10;
            num /= 10;
        }
        return addDigits(add);
    }
}
