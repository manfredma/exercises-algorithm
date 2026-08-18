package manfred.exercises.leetcode.solved.p0001to0100.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 93 题「复原 IP 地址」：动态规划，二维缓存自底向上枚举所有合法段组合。
 * <p>
 * 思路：cache[i][j] = 从下标 j 起、切成 i+1 段的所有合法拼接串。i=0 为单段 base case
 * （j 到串尾的子串须无前导 0 且 ≤255）；i>0 时枚举本段终点 k，cache[i][j] 由
 * 「本段 + '.' + cache[i-1][k]」组合而成。自底向上填满 cache[3][0] 即四段全解。
 * <p>
 * 关键点：从右向左填表保证依赖的 cache[i-1][k] 已就绪；单段前导 0 仅允许 "0" 本身。
 * 复杂度：时间 O(n²)（每状态枚举段长），空间 O(n²)（4×n 个 List，每个最多存串）。
 * <p>
 * 与 {@link Solution} 演进：旧解用 num/2 分治（仅对 2 幂段数有效）；本解通用递推，
 * 段数任意可扩展。对照 {@link Solution3} 的 BFS 层序为再刷解。
 */
class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return new ArrayList<>();
        }
        List<String>[][] cache = new List[4][s.length()];
        for (int i = 0; i < 4; i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                cache[i][j] = new ArrayList<>();
                if (i > 0) {
                    if (j == s.length() - 1) {
                        continue;
                    }
                    if (s.charAt(j) == '0') {
                        for (int k = 0; k < cache[i - 1][j + 1].size(); k++) {
                            cache[i][j].add("0." + cache[i - 1][j + 1].get(k));
                        }
                    } else {
                        for (int k = j + 1; k < s.length(); k++) {
                            if (s.substring(j, k).length() < 4 && Integer.parseInt(s.substring(j, k)) <= 255) {
                                for (int l = 0; l < cache[i - 1][k].size(); l++) {
                                    cache[i][j].add(s.substring(j, k) + "." + cache[i - 1][k].get(l));
                                }
                            }
                        }
                    }
                } else {
                    if (s.charAt(j) == '0') {
                        if (j == s.length() - 1) {
                            cache[i][j].add(s.substring(j));
                        }
                    } else {
                        if (s.substring(j).length() < 4 && Integer.parseInt(s.substring(j)) <= 255) {
                            cache[i][j].add(s.substring(j));
                        }
                    }
                }
            }
        }
        return cache[3][0];
    }
}