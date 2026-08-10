package manfred.exercises.leetcode.solved.p0401to0500.p0443;

/** 题目链接：https://leetcode.cn/problems/string-compression/ */

import java.util.Arrays;

/*
给你一个字符数组 chars，请使用下述算法压缩：

从一个空字符串 s 开始。对于 chars 中的每组连续重复字符：
如果这一组长度为 1，则将字符追加到 s 中。
否则，需要向 s 追加字符，后跟这一组的长度。

压缩后得到的字符串 s 不应该直接返回，需要转储到字符数组 chars 中。
如果组长度为 10 或以上，则在 chars 数组中会被拆分为多个字符。

请在修改完输入数组后，返回该数组的新长度。
你必须设计并实现一个只使用常量额外空间的算法来解决此问题。

注意：数组中超出返回长度的字符无关紧要，应予忽略。

示例 1：
输入：chars = ["a","a","b","b","c","c","c"]
输出：6
解释：分组是 "aa"、"bb" 和 "ccc"，压缩为 "a2b2c3"。
在原地修改输入数组之后，chars 的前 6 个字符应为 ["a","2","b","2","c","3"]。

示例 2：
输入：chars = ["a"]
输出：1
解释：唯一的组是 "a"，因为它是一个单独的字符，所以保持不变。

示例 3：
输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
输出：4
解释：分组是 "a" 和 "bbbbbbbbbbbb"，压缩为 "ab12"。
在对输入数组进行原地修改后，chars 的前 4 个字符应为 ["a","b","1","2"]。

提示：
1 <= chars.length <= 2000
chars[i] 可以是小写英文字母、大写英文字母、数字或符号。
*/
/** LeetCode 第 443 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        assertCompressed(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, "a2b2c3");
        assertCompressed(new char[]{'a'}, "a");
        assertCompressed(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, "ab12");
        assertCompressed(new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}, "a10");
        assertCompressed(new char[]{'a', 'a', 'a', 'b', 'b', 'c'}, "a3b2c");
    }

    private static void assertCompressed(char[] chars, String expected) {
        Solution solution = new Solution();
        int actualLength = solution.compress(chars);
        char[] actual = Arrays.copyOf(chars, actualLength);
        char[] expectedChars = expected.toCharArray();
        if (!Arrays.equals(expectedChars, actual)) {
            throw new AssertionError("期望：" + expected + "，实际：" + new String(actual));
        }
        System.out.println("通过：" + expected);
    }
}
