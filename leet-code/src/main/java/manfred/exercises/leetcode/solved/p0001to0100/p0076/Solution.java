package manfred.exercises.leetcode.solved.p0001to0100.p0076;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 76 题「最小覆盖子串」（方案 1）：为目标串中的每个字符维护其在源串中最近出现的下标。
 * 该方案能得到正确结果，但会反复调用 {@link String#indexOf(int)}、扫描下标列表，状态复杂且最坏
 * 时间复杂度为 O(mn)，仅保留作思路对照；方案 2 和方案 3 均为 O(m + n) 的滑动窗口解法。
 */
class Solution {
    public String minWindow(String s, String t) {
        List<Integer>[] charLastIndex = new List[t.length()];
        for (int i = 0; i < charLastIndex.length; i++) {
            char c = t.charAt(i);
            int cI = t.indexOf(c);
            if (i == cI) {
                charLastIndex[i] = new ArrayList<>();
                charLastIndex[i].add(-1);
            } else {
                charLastIndex[cI].add(-1);
                charLastIndex[i] = new ArrayList<>();
            }
        }

        int minLength = -1;
        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        boolean isFind = false;
        // 窗口左侧
        int windowLeft = Integer.MAX_VALUE;
        boolean needTransferWindow = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cI = t.indexOf(c);
            if (cI == -1) {
                continue;
            }
            if (charLastIndex[cI].size() == 1) {
                int old = charLastIndex[cI].set(0, i);
                if (old == windowLeft) {
                    needTransferWindow = true;
                    windowLeft = Integer.MAX_VALUE;
                }
            } else {
                List<Integer> integers = charLastIndex[cI];
                boolean insert = false;
                for (int j = 0; j < integers.size(); j++) {
                    if (integers.get(j) == -1) {
                        insert = true;
                        integers.set(j, i);
                        if (j == integers.size() - 1) {
                            needTransferWindow = true;
                        }
                        break;
                    }
                }
                if (!insert) {
                    if (integers.get(0) == windowLeft) {
                        needTransferWindow = true;
                        windowLeft = Integer.MAX_VALUE;
                    }
                    for (int j = 0; j < integers.size() - 1; j++) {
                        integers.set(j, integers.get(j + 1));
                    }
                    integers.set(integers.size() - 1, i);
                }
            }
            if (!isFind) {
                boolean isAllFind = true;
                for (int j = 0; j < charLastIndex.length; j++) {
                    for (int k = 0; k < charLastIndex[j].size(); k++) {
                        if (charLastIndex[j].get(k) == -1) {
                            isAllFind = false;
                            break;
                        }
                    }
                    if (!isAllFind) {
                        break;
                    }
                }
                if (isAllFind) {
                    isFind = true;
                    needTransferWindow = true;
                }
            }

            if (isFind) {
                if (needTransferWindow) {
                    for (int k = 0; k < charLastIndex.length; k++) {
                        if (charLastIndex[k].size() > 0 && charLastIndex[k].get(0) < windowLeft) {
                            windowLeft = charLastIndex[k].get(0);
                        }
                    }
                    needTransferWindow = false;
                }
                if (minLength == -1 || (i - windowLeft + 1) < minLength) {
                    minLength = i - windowLeft + 1;
                    begin = windowLeft;
                    end = i;
                }
            }
        }

        if (minLength != -1) {
            return s.substring(begin, end + 1);
        } else {
            return "";
        }
    }
}
