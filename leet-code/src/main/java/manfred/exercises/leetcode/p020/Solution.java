package manfred.exercises.leetcode.p020;

import java.util.Stack;

/**
 * LeetCode 第 20 题「有效的括号」：栈匹配，遇到左括号入栈，遇到右括号与栈顶匹配。
 */
class Solution {

    public boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }

        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i] || '{' == chars[i] || '[' == chars[i]) {
                characters.push(chars[i]);
            } else {
                char r = chars[i];
                int size = characters.size();
                if (size == 0) {
                    return false;
                }
                char l = characters.pop();
                if (!(l == '(' && r == ')'
                        || l == '{' && r == '}'
                        || l == '[' && r == ']')) {
                    return false;
                }
            }
        }
        return characters.size() == 0;
    }
}