package manfred.exercises.leetcode.solved.p3101to3200.p3110;

/**
 * 字符串的分数（LeetCode 3110）。
 *
 * <p>分数定义为相邻字符 ASCII 码差值绝对值的和。单趟扫描，累加
 * {@code Math.abs(s.charAt(i) - s.charAt(i-1))} 即可；长度为 1 时无相邻对，和为 0（题目保证 length >= 2）。</p>
 *
 * <p>时间复杂度 O(n)，空间复杂度 O(1)。</p>
 */
class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(s.charAt(i) - s.charAt(i -1));
        }
        return sum;
    }
}
