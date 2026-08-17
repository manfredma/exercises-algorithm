package manfred.exercises.ctci.c0101;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.01「判断字符是否唯一」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：leetcode 含重复 e → false
        assertFalse(solution.isUnique("leetcode"));
        // 手算：abc 各字符唯一 → true
        assertTrue(solution.isUnique("abc"));
        System.out.println("passed");
    }
}
