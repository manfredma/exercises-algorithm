package manfred.exercises.ctci.c0106;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.06「字符串压缩」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例1
        assertEquals("a2b1c5a3", solution.compressString("aabcccccaaa"));
        // 题面示例2：压缩串长于原串，返回原串
        assertEquals("abbccd", solution.compressString("abbccd"));
        System.out.println("passed");
    }
}
