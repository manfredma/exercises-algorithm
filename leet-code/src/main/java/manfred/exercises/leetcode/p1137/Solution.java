package manfred.exercises.leetcode.p1137;

class Solution {
    public int tribonacci(int n) {
        // T0 = 0, T1 = 1, T2 = 1
        //Tn+3 = Tn + Tn+1 + Tn+2（n >= 0）

        int t0 = 0, t1 = 1, t2 = 1;
        if (n == 0) {
            return t0;
        }
        if (n == 1) {
            return t1;
        }
        if (n == 2) {
            return t2;
        }
        int r = 0;
        for (int i = 3; i <= n; i++) {
            r = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = r;
        }
        return r;
    }
}
