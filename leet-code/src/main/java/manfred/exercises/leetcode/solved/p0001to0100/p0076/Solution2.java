package manfred.exercises.leetcode.solved.p0001to0100.p0076;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 76 题「最小覆盖子串」（方案 2）：使用哈希表记录目标字符的剩余需求，
 * 找到覆盖窗口后收缩左边界。
 *
 * <p>左右指针均单调右移，哈希表仅保存目标串中的字符，时间复杂度为 O(m + n)，空间复杂度为 O(k)，
 * 其中 k 为目标串中不同字符的数量。方案 3 将相同状态压缩为字符数组和缺失字符总数，更适合作为模板。</p>
 */
class Solution2 {
    public String minWindow(String s, String t) {
        // 使用滑动窗口的方式来进行处理，当找到第一个完全包含 t 的时候，进入窗口
        Map<Character, Integer> tCharCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCharCount.merge(t.charAt(i), 1, Integer::sum);
        }
        int noneZeroCharNum = tCharCount.size();
        String r = "";
        // 循环 S 的字符串
        int left = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (!tCharCount.containsKey(s.charAt(i))) {
                continue;
            }
            tCharCount.merge(s.charAt(i), -1, Integer::sum);
            if (tCharCount.get(s.charAt(i)) == 0) {
                noneZeroCharNum--;
            }
            // 窗口已经满足要求了
            if (noneZeroCharNum == 0) {
                // 说明已经进入了全 0 的情况, 需要先尝试收紧左侧
                while (true) {
                    if (!tCharCount.containsKey(s.charAt(left))) {
                        left++;
                        continue;
                    }
                    if (tCharCount.get(s.charAt(left)) == 0) {
                        // 遇到了关键字符，再移动则意味着当前窗口不再包含完整的 T
                        break;
                    }
                    tCharCount.merge(s.charAt(left), 1, Integer::sum);
                    left++;
                }
                if (i - left < len) {
                    r = s.substring(left, i + 1);
                    len = i - left;
                }

            }
        }

        return r;
    }
}
