package manfred.exercises.leetcode.p0394;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');          // 支持多位数，如 12[a]
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                String sub = current.toString();
                current = strStack.pop();
                int repeat = countStack.pop();
                for (int i = 0; i < repeat; i++) {
                    current.append(sub);
                }
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}
