package exe204.count.primes;

/**
 * LeetCode 第 204 题「计数质数」：埃拉托斯特尼筛法，标记合数。
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int[] x = new int[n];
        for (int i = 2; i < n; i++) {
            if (x[i] != -1) {
                x[i] = i;
                for (int j = i * 2; j < n; j += i) {
                    x[j] = -1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (x[i] > 0) {
                result++;
            }
        }

        return result;
    }
}