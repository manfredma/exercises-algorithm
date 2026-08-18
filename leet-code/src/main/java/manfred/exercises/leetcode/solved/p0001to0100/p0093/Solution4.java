package manfred.exercises.leetcode.solved.p0001to0100.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 93 题「复原 IP 地址」：再刷解法，标准回溯。
 * <p>
 * 思路：递归枚举每一段的长度 1-3，截取子串校验为合法段（无前导 0、≤255）后加入路径，
 * 凑满 4 段且恰好用尽整个串即收集为一个解。递归参数：当前下标 start、已切段数 count、路径。
 * <p>
 * 剪枝：剩余字符数不足 (4-count) 段（每段至少 1 位）或超过 3*(4-count) 位时提前返回；
 * 段长超过剩余长度或首位为 0 且长度>1 时跳过。
 * 复杂度：时间 O(3^4)=常数级（段数固定 4，每段至多 3 种长度），空间 O(递归栈 4)。
 * <p>
 * 与 {@link Solution3} 对比：BFS 层序需预处理 starts 表 + 队列扩展（~90 行）；
 * 本解递归回溯直述「枚举每段」，~25 行，是 93 题的标准首选模板。
 */
class Solution4 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, int count, List<String> path, List<String> result) {
        // 凑满 4 段：恰好用尽整串则收集，否则剪枝
        if (count == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        // 剪枝：剩余字符不足以凑齐剩余段，或剩余段最多容纳的字符仍放不下
        int remain = s.length() - start;
        if (remain < (4 - count) || remain > 3 * (4 - count)) {
            return;
        }
        // 枚举本段长度 1-3
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            if (isValidSegment(s, start, start + len)) {
                path.add(s.substring(start, start + len));
                backtrack(s, start + len, count + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    /** 校验 s[from, to) 是否为合法 IP 段：无前导 0（单独 "0" 除外）且 ≤255。 */
    private boolean isValidSegment(String s, int from, int to) {
        if (from < to && s.charAt(from) == '0') {
            return to - from == 1; // 前导 0 仅允许 "0" 本身
        }
        int value = 0;
        for (int i = from; i < to; i++) {
            value = value * 10 + (s.charAt(i) - '0');
        }
        return value <= 255;
    }
}
