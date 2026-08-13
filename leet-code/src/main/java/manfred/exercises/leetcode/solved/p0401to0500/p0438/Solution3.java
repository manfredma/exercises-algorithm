package manfred.exercises.leetcode.solved.p0401to0500.p0438;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<Integer> findAnagrams(String s, String p) {
        // 初始化字母的数量
        List<Integer> r = new ArrayList<>();
        int[] charNumOfP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charNumOfP[p.charAt(i) - 'a']++;
        }

        // 计算非 0 字母的个数，当窗口正好导致所有数字全为 0，则认为命中
        int nonZeroNum = 0;
        for (int i = 0; i < 26; i++) {
            if (charNumOfP[i] != 0) {
                nonZeroNum++;
            } else {
                // 表示 P 中没有这个元素
                charNumOfP[i] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                // 进入了窗口范围，需要开始淘汰元素
                int evictIdx = i - p.length();
                int pIdx = s.charAt(evictIdx) - 'a';
                if (charNumOfP[pIdx] != Integer.MIN_VALUE) {
                    //  退出窗口的，之前抵消的要加回来
                    charNumOfP[pIdx]++;
                    if (charNumOfP[pIdx] == 0) {
                        nonZeroNum--;
                    } else if (charNumOfP[pIdx] == 1) {
                        nonZeroNum++;
                    }
                }
            }
            int idx = s.charAt(i) - 'a';
            // 加入元素
            if (charNumOfP[idx] == Integer.MIN_VALUE) {
                continue;
            }
            // 新进入窗口的要抵消一个
            charNumOfP[idx]--;
            if (charNumOfP[idx] == 0) {
                nonZeroNum--;
            } else if (charNumOfP[idx] == -1) {
                nonZeroNum++;
            }

            if (nonZeroNum == 0) {
                r.add(i - p.length() + 1);
            }
        }

        return r;
    }
}
