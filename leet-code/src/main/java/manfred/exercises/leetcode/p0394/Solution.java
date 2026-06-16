package manfred.exercises.leetcode.p0394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (']' == s.charAt(i)) {
                StringBuilder segment = new StringBuilder();
                while (stack.peek() != '[') {
                    segment.insert(0, stack.pop());
                }
                stack.pop();
                int digitPos = 0;
                int repeatCount = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    repeatCount += (int) Math.pow(10, digitPos) * (stack.pop() - '0');
                    digitPos++;
                }
                for (int j = 0; j < repeatCount; j++) {
                    for (int k = 0; k < segment.length(); k++) {
                        stack.push(segment.charAt(k));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
