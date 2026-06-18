package manfred.exercises.leetcode.p0433;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    private static final char[] BASES = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        visited.add(startGene);
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] curr = queue.poll().toCharArray();
                for (int j = 0; j < curr.length; j++) {
                    char original = curr[j];
                    for (char c : BASES) {
                        if (c == original) continue;
                        curr[j] = c;
                        String next = new String(curr);
                        if (next.equals(endGene)) return steps;
                        if (bankSet.contains(next) && visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                    curr[j] = original; // 还原，复用数组
                }
            }
        }
        return -1;
    }
}
