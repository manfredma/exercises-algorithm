package exe60.permutation.sequence;

/**
 * LeetCode 第 60 题「排列序列」：逐位确定数字，用阶乘计算每位应选第几个剩余数字。
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] nFactorial = new int[n + 1];
        nFactorial[0] = 1;
        StringBuilder initString = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            nFactorial[i] = i * nFactorial[i - 1];
            initString.append(i);
        }

        if (k > nFactorial[n]) {
            return null;
        }
        k--;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            int remainder = k / nFactorial[n - 1 - i];
            result.append(initString.charAt(remainder));
            initString.deleteCharAt(remainder);
            k = k % nFactorial[n - 1 - i];
        }
        result.append(initString);
        return result.toString();
    }
}