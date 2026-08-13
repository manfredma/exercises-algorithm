package manfred.exercises.leetcode.solved.p0701to0800.p0763;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public List<Integer> partitionLabels(String s) {
        // 使用贪心算法来完整这个工作，尽量早的结束前面的字符串
        // 获取每个字母的最后一次出现的位置
        int[] end = new int[26];
        for (int i = 0; i < s.length(); i++) {
            end[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        int curEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            // 尝试更新 maxEnd
            curEnd = Math.max(curEnd, end[s.charAt(i) - 'a']);
            // 相等说明已经遍历到可以拆分的这一段的末尾了
            if (curEnd == i) {
                result.add(curEnd - lastEnd);
                lastEnd = curEnd;
            }
        }
        return result;
    }
}
