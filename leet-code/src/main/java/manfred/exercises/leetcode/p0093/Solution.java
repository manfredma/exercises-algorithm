package manfred.exercises.leetcode.p0093;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 93 题「复原 IP 地址」：回溯法，按段枚举 0-255 范围内的数字。
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