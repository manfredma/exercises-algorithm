package manfred.exercises.ctci.c0102;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.02「判定是否互为字符重排」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 手算：a 频次不同 → false
        assertFalse(solution.CheckPermutation("aa", "ab"));
        // 手算：abc 与 bca 频次相同 → true
        assertTrue(solution.CheckPermutation("abc", "bca"));
        // 手算：完全相同 → true
        assertTrue(solution.CheckPermutation("aa", "aa"));
        System.out.println("passed");
    }
}
