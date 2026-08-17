package manfred.exercises.ctci.c0104;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.04「回文排列」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：tactcoa 奇数频次字符仅 o → true
        assertTrue(solution.canPermutePalindrome("tactcoa"));
        // 手算：a/b/d 各 1 次，奇数频次 3 个 → false
        assertFalse(solution.canPermutePalindrome("abd"));
        // 手算：a 频次 3，奇数频次 1 个，长度为奇数 → true
        assertTrue(solution.canPermutePalindrome("aaa"));
        System.out.println("passed");
    }
}
