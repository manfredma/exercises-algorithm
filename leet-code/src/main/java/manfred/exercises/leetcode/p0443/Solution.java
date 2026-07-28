package manfred.exercises.leetcode.p0443;

class Solution {
    public int compress(char[] chars) {
        // 题目以保证至少包含一个元素！
        char cur = chars[0];
        int cnt = 1;

        int len = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                cnt++;
            } else {
                // 开始了新元素
                if (cnt > 1) {
                    len = appendLen(chars, cnt, len);
                }
                // 处理下一阶段
                cur = chars[i];
                chars[len] = chars[i];
                cnt = 1;
                len++;
            }
        }
        // 补上结尾（如果结尾是多个重复元素，需要补充一下循环次数）
        if (cnt > 1) {
            // 需要拼接长度
            len = appendLen(chars, cnt, len);
        }
        return len;
    }

    private int appendLen(char[] chars, int cnt, int len) {
        int divisor = 1;
        while (cnt / divisor >= 10) {
            divisor *= 10;
        }
        while (divisor > 0) {
            chars[len++] = (char) ('0' + cnt / divisor);
            cnt %= divisor;
            divisor /= 10;
        }
        return len;
    }
}
