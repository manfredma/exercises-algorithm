package manfred.exercises.leetcode.solved.p0601to0700.p0649;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        // 开始模拟投票
        while (true) {
            if (direQueue.isEmpty()) {
                return "Radiant";
            }
            if (radiantQueue.isEmpty()) {
                return "Dire";
            }
            if (direQueue.peek() < radiantQueue.peek()) {
                direQueue.offer(direQueue.poll() + len);
                radiantQueue.poll();
            } else {
                radiantQueue.offer(radiantQueue.poll() + len);
                direQueue.poll();
            }
        }
    }
}
