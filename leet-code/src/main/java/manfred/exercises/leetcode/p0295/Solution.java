package manfred.exercises.leetcode.p0295;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    // 大顶堆的数量与小顶堆的元素数量相等或+1， 所有<=中间值的元素都在大顶堆中，同理，所有>=中间值的元素都在小顶堆中
    private final PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        // 大顶堆为空，则放入大顶堆
        if (maxQueue.isEmpty()) {
            maxQueue.add(num);
            return;
        }

        if (findMedian() >= num) {
            // num 较小，应该放入大顶堆
            maxQueue.add(num);
            if (maxQueue.size() > minQueue.size() + 1) {
                minQueue.add(maxQueue.poll());
            }
        } else {
            minQueue.add(num);
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.add(minQueue.poll());
            }
        }

    }

    public double findMedian() {
        if (maxQueue.isEmpty()) {
            return 0.0;
        }
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        }
        return (maxQueue.peek() + minQueue.peek()) / 2.0;
    }
}
