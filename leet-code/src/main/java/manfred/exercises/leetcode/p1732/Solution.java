package manfred.exercises.leetcode.p1732;

class Solution {
    public int largestAltitude(int[] gain) {
        int result = 0;
        int pre = 0;
        for (int i : gain) {
            int cur = i + pre;
            result = Math.max(result, cur);
            pre = cur;
        }
        return result;
    }
}
