package manfred.exercises.leetcode.solved.p1201to1300.p1207;

/** 题目链接：https://leetcode.cn/problems/unique-number-of-occurrences/ */

/*
给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

示例 1：arr = [1,2,2,1,1,3]，输出：true。
示例 2：arr = [1,2]，输出：false。
示例 3：arr = [-3,0,1,-3,1,1,1,-3,10,0]，输出：true。

提示：1 <= arr.length <= 1000；-1000 <= arr[i] <= 1000。
*/
/** LeetCode 第 1207 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(true, solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        assertEquals(false, solution.uniqueOccurrences(new int[]{1, 2}));
        assertEquals(true, solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
