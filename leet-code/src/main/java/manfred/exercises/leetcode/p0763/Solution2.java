package manfred.exercises.leetcode.p0763;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> partitionLabels(String s) {
        // 第一步：记录每个字母最后出现的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // 第二步：贪心扫描，维护当前片段的边界
        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 当前片段必须延伸到包含 s[i] 最后一次出现的位置
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            // 走到 end 说明片段内所有字母都"收尾"了，切割
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
