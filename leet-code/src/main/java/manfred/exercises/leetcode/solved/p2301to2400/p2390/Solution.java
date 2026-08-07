package manfred.exercises.leetcode.solved.p2301to2400.p2390;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                }
            } else {
                deque.offerFirst(s.charAt(i));
            }
        }
        // 拼接返回值
        StringBuilder r = new StringBuilder();
        while (!deque.isEmpty()) {
            r.append(deque.pollLast());
        }
        return r.toString();
    }
}
