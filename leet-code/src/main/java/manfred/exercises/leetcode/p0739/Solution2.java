package manfred.exercises.leetcode.p0739;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int waitingIdx = stack.pop();
                answer[waitingIdx] = i - waitingIdx;
            }
            stack.push(i);
        }

        return answer;
    }
}
