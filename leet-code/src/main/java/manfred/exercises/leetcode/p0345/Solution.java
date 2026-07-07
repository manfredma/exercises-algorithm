package manfred.exercises.leetcode.p0345;

import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
