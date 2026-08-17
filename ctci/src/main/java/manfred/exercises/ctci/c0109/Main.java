package manfred.exercises.ctci.c0109;

import static manfred.exercises.assertion.Assert.*;

/**
 * CTCI 面试题 01.09「字符串轮转」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例1：erbottlewat 为 waterbottle 的轮转
        assertTrue(solution.isFlipedString("waterbottle", "erbottlewat"));
        // 题面示例2：长度不同 → false
        assertFalse(solution.isFlipedString("aa", "aba"));
        System.out.println("passed");
    }
}
