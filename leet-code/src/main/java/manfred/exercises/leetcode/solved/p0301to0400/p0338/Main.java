package manfred.exercises.leetcode.solved.p0301to0400.p0338;

import java.util.Arrays;

/*
给你一个整数 n，对于 0 <= i <= n 中的每个 i，计算其二进制表示中 1 的个数，返回长度为 n + 1 的数组 ans。
不要使用内置函数解决。

示例 1：n = 2，输出：[0,1,1]。
示例 2：n = 5，输出：[0,1,1,2,1,2]。

提示：0 <= n <= 10^5。
进阶：能否在线性时间复杂度 O(n) 内用一趟扫描解决？
*/
/** LeetCode 第 338 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{0, 1, 1}, solution.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, solution.countBits(5));
    }

    private static void assertArrayEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) throw new AssertionError("expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    }
}
