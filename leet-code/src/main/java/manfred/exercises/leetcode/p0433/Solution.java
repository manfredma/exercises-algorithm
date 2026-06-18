package manfred.exercises.leetcode.p0433;

import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        int steps = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String q = queue.poll();
                if (Objects.equals(q, endGene)) {
                    return steps;
                }
                List<String> adj = adj(bank, q);
                for (String s : adj) {
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }

            }
            steps++;
        }

        return -1;
    }

    private List<String> adj(String[] bank, String gene) {
        List<String> result = new ArrayList<>();
        for (String s : bank) {
            if (isAdj(s, gene)) {
                result.add(s);
            }
        }
        return result;
    }

    private boolean isAdj(String gene1, String gene2) {
        int diff = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }


}
