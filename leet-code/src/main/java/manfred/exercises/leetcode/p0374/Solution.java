package manfred.exercises.leetcode.p0374;

/**
 * LeetCode 第 374 题「猜数字大小」。
 *
 * <p>继承 {@link GuessGame} 获得题目给定的 guess(int num) 接口，签名与线上一致。
 */
class Solution extends GuessGame {

    /** 线上提交用：pick 由系统在 GuessGame 内部设定，这里给个占位。 */
    public Solution() {
        super(0);
    }

    /** 本地测试用：显式指定 pick。 */
    public Solution(int pick) {
        super(pick);
    }

    /**
     * 猜出 pick 是哪个数字。候选范围为 1..n，二分查找。
     *
     * @param n 数字范围上界
     * @return 猜中的数字
     */
    public int guessNumber(int n) {
        int from = 1;
        while (true) {
            // 用 from + (n - from) / 2 而非 (from + n) / 2，防 from+n 溢出
            int mid = from + (n - from) / 2;
            int r = guess(mid);
            if (r == 0) {
                return mid;
            } else if (r == 1) {
                from = mid + 1;
            } else {
                n = mid - 1;
            }
        }
    }
}
