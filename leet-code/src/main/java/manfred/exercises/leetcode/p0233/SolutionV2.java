package manfred.exercises.leetcode.p0233;

/**
 * LeetCode 第 233 题「数字 1 的个数」（方案2）：逐位统计各位上数字 1 的出现次数，数学公式推导。
 */
class SolutionV2 {

    public int countDigitOne(int n) {

        long mulk = 1;
        int ans = 0;

        for (int k = 0; n >= mulk; k++) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

}