package manfred.exercises.leetcode.p2336;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private Set<Integer> addedBack = new HashSet<>();
    private int nextSmallest = 1;
    SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (!priorityQueue.isEmpty()) {
            int result = priorityQueue.poll();
            addedBack.remove(result);
            return result;
        }
        return nextSmallest++;
    }

    public void addBack(int num) {
        if (num >= nextSmallest) {
            // 重复元素
            return;
        }
        if (addedBack.add(num)) {
            priorityQueue.offer(num);
        }
    }
}
