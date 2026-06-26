package manfred.exercises.leetcode.p0682;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String operation : operations) {
            switch (operation) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int pre = stack.pop();
                    int cur = stack.peek() + pre;
                    stack.push(pre);
                    stack.push(cur);
                    break;
                default:
                    stack.push(Integer.valueOf(operation));
                    break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
