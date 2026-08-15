package manfred.exercises.leetcode.solved.p0001to0100.p0076;

/**
 * LeetCode 第 76 题「最小覆盖子串」（方案 3）：标准滑动窗口模板。
 * {@code need[c]} 表示当前窗口仍缺少的字符 {@code c} 数量，{@code missing} 表示还缺少的字符总数。
 * 右指针扩张直到窗口覆盖目标串，再移动左指针尽量收缩；移除不可替代的字符时窗口重新失效。
 *
 * <p>题目限定字符为英文字母，使用长度为 128 的数组代替哈希表。每个字符至多被左右指针访问两次，
 * 时间复杂度为 O(m + n)，空间复杂度为 O(1)。</p>
 */
class Solution3 {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int missing = t.length();
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (need[rightChar]-- > 0) {
                missing--;
            }

            while (missing == 0) {
                if (right - left + 1 < bestLength) {
                    bestStart = left;
                    bestLength = right - left + 1;
                }
                char leftChar = s.charAt(left++);
                if (++need[leftChar] > 0) {
                    missing++;
                }
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
