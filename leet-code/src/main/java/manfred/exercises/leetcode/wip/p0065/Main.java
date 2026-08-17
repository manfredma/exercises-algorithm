/*

Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous.
You should gather all requirements up front before implementing one.
However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."

Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated.
If you still see your function signature accepts a const char * argument,
please click the reload button to reset your code definition.

 */

package manfred.exercises.leetcode.wip.p0065;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/valid-number/ */

/**
 * LeetCode 第 65 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertTrue(solution.isNumber("3."));
        assertTrue(solution.isNumber(" 0.1 "));
        assertTrue(solution.isNumber("2e10"));
        assertTrue(solution.isNumber("0"));
        assertFalse(solution.isNumber("abc"));
        assertFalse(solution.isNumber("1 a"));
        assertTrue(solution.isNumber(" -90e3   "));
        assertFalse(solution.isNumber(" 1e"));
        assertFalse(solution.isNumber("e3"));
        assertFalse(solution.isNumber(" 99e2.5 "));
        assertTrue(solution.isNumber("53.5e93"));
        assertFalse(solution.isNumber(" --6 "));
        assertFalse(solution.isNumber("-+3"));
        assertFalse(solution.isNumber("95a54e53"));
        System.out.println("p0065 all assertions passed");
    }
}
