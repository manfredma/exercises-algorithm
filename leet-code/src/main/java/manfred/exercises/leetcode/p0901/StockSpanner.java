package manfred.exercises.leetcode.p0901;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class StockSpanner {

    private List<Integer> prices = new ArrayList<>();
    private Deque<Integer> deque = new ArrayDeque<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int idx = prices.size();
        prices.add(price);
        while (!deque.isEmpty() && prices.get(deque.peek()) <= price) {
            deque.pop();
        }
        int from = -1;
        if (!deque.isEmpty()) {
            from = deque.peek();
        }
        deque.push(idx);
        return idx - from;
    }
}
