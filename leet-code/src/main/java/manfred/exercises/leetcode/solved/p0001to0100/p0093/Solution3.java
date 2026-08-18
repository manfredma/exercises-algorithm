package manfred.exercises.leetcode.solved.p0001to0100.p0093;

import java.util.*;

/**
 * LeetCode 第 93 题「复原 IP 地址」：再刷解法，BFS 层序（预处理起点表 + 4 层扩展）。
 * <p>
 * 思路：先扫描构造 starts 表——starts[i] = 从下标 i 出发可形成的所有合法段终点列表
 * （段长 1-3、无前导 0、≤255）；再以 starts[0] 的终点为种子，BFS 逐层拼接下一段，
 * 共扩展 4 层；最后收集终点恰为 n-1 的路径，按段下标切片拼回 IP 串。
 * <p>
 * 关键点：isValidPart 截断前导 0（仅 "0" 合法）与超界（>255）；BFS 层数即 IP 段数 4。
 * 复杂度：时间 O(n²) 预处理 + O(路径数) 扩展，空间 O(n²)（starts 表 + 队列候选）。
 * <p>
 * 与 {@link Solution}/{@link Solution2} 对比：本解用 BFS 显式按层扩展，思路不同于
 * 分治/DP 递推，代码量偏大（~90 行）但状态推进清晰；标准回溯通常更简洁，本解作对照留存。
 */
class Solution3 {
    public List<String> restoreIpAddresses(String s) {
        List<String> r = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return r;
        }
        // 记录从某个位置开始可以拼接的字符串，作为备忘录，后面不需要再拼接数字
        Map<Integer, List<Integer>> starts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isValidPart(s, i, j)) {
                    List<Integer> add = new ArrayList<>();
                    add.add(j);
                    starts.merge(i, add, (old, a) -> {
                        old.addAll(a);
                        return old;
                    });
                } else {
                    // 只要第一个不是，则往后都不会再出现合法的数字
                    break;
                }
            }
        }

        // 使用广度优先遍历来获取恰好可以切分字符串的方式
        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> firstEnd = starts.get(0);
        firstEnd.forEach(a -> {
            List<Integer> candidate = new ArrayList<>();
            candidate.add(a);
            queue.offer(candidate);
        });

        int level = 1;
        while (!queue.isEmpty()) {
            if (level == 4) {
                break;
            }
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                List<Integer> candidate = queue.poll();
                int lastEnd = candidate.get(candidate.size() - 1);
                List<Integer> newEnds = starts.getOrDefault(lastEnd + 1, Collections.emptyList());
                for (Integer newEnd : newEnds) {
                    List<Integer> newCandidate = new ArrayList<>(candidate);
                    newCandidate.add(newEnd);
                    queue.offer(newCandidate);
                }
            }
            level++;
        }

        // 收获结果
        while (!queue.isEmpty()) {
            List<Integer> candidate = queue.poll();
            if (candidate.get(candidate.size() - 1) == s.length() - 1) {
                StringBuilder candidateString = new StringBuilder(s.substring(0, candidate.get(0) + 1));
                int lastEnd = candidate.get(0);
                for (int i = 1; i < 4; i++) {
                    candidateString.append(".");
                    candidateString.append(s.substring(lastEnd + 1, candidate.get(i) + 1));
                    lastEnd = candidate.get(i);
                }
                r.add(candidateString.toString());
            }
        }
        return r;
    }

    private boolean isValidPart(String s, int from, int end) {
        if (end - from > 2) {
            return false;
        }
        if (s.charAt(from) == '0' && end == from) {
            return true;
        }
        if (s.charAt(from) != '0') {
            int result = 0;
            for (int i = from; i <= end; i++) {
                result *= 10;
                result += s.charAt(i) - '0';
            }
            return result <= 255;
        }
        return false;
    }
}
