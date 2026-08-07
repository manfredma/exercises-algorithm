package manfred.exercises.leetcode.solved.p0901to1000.p0933;

import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {
    private final Deque<Integer> queue = new ArrayDeque<>();

    RecentCounter() {

    }

    public int ping(int t) {
        while (queue.peek() != null && t - queue.peek() > 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
