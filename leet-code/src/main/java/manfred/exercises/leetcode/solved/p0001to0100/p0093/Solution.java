package manfred.exercises.leetcode.solved.p0001to0100.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 93 题「复原 IP 地址」：分治法，按段数对半递归（num/2 二分）。
 * <p>
 * 思路：把切 num 段的问题对半分为切 num/2 段（前缀）+ num/2 段（后缀），枚举分割点 i
 * 笛卡尔积拼接；num==1 为 base case（整段须无前导 0 且 ≤255，单字符 "0" 例外）。
 * <p>
 * 关键点：num/2 整数除法对 IP 4 段恰好有效——4→2+2→1+1+1+1，num 只取 4/2/1，
 * 不出现 3 段；故分治正确但不通用（段数须为 2 的幂）。能跑、巧妙，非首选模板。
 * 复杂度：时间 O(路径数)，空间 O(递归栈)。
 * <p>
 * 对照 {@link Solution2}（DP 通用递推）、{@link Solution3}（BFS 层序）为再刷解。
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }
        return restoreIpAddresses(s, 4);
    }

    private List<String> restoreIpAddresses(String s, int num) {
        List<String> result = new ArrayList<>();
        if (num == 1) {
            if (s.length() == 1) {
                result.add(s);
            } else if (s.charAt(0) != '0' && s.length() < 4 && Integer.parseInt(s) <= 255) {
                result.add(s);
            }
        } else {
            for (int i = 1; i < s.length(); i++) {
                List<String> first = restoreIpAddresses(s.substring(0, i), num / 2);
                if (first.size() == 0) {
                    continue;
                }
                List<String> last = restoreIpAddresses(s.substring(i), num / 2);
                for (String s1 : first) {
                    for (String s2 : last) {
                        result.add(s1 + "." + s2);
                    }
                }
            }
        }
        return result;
    }
}