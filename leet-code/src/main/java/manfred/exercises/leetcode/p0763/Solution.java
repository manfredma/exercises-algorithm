package manfred.exercises.leetcode.p0763;

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        // 构造每个字母的范围！
        Map<Character, int[]> characterRange = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterRange.merge(s.charAt(i), new int[]{i, i}, (a, b) -> new int[]{a[0], b[1]});
        }
        PriorityQueue<int[]> sortedRange = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        characterRange.forEach((a, b) -> sortedRange.add(b));
        int[] currentRange = sortedRange.poll();
        while (!sortedRange.isEmpty()) {
            int[] nextRange = sortedRange.poll();
            if (nextRange[0] > currentRange[1]) {
                result.add(currentRange[1] - currentRange[0] + 1);
                currentRange = nextRange;
            } else {
                currentRange[1] = Math.max(currentRange[1], nextRange[1]);
            }
        }
        result.add(currentRange[1] - currentRange[0] + 1);
        return result;
    }
}
