package manfred.exercises.leetcode.solved.p3001to3100.p3069;

import static manfred.exercises.assertion.Assert.assertEquals;

/**
 * LeetCode 第 3069 题的测试入口。
 *
 * @see <a href="https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/">LeetCode 中文站</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 官方示例
        assertEquals(new int[]{2, 3, 1}, solution.resultArray(new int[]{2, 1, 3}), "example 1");
        assertEquals(new int[]{5, 3, 4, 8}, solution.resultArray(new int[]{5, 4, 3, 8}), "example 2");

        // 边界：最小长度 n=3，arr1 自始至终领先。
        assertEquals(new int[]{3, 1, 2}, solution.resultArray(new int[]{3, 2, 1}), "n=3, arr1 keeps lead");
        // 严格递增：arr2 自第三次操作起持续领先，剩余元素全部并入 arr2。
        assertEquals(new int[]{1, 2, 3, 4, 5}, solution.resultArray(new int[]{1, 2, 3, 4, 5}), "strictly increasing");
        // 严格递减：每次比较在两个数组间交替切换。
        assertEquals(new int[]{5, 3, 1, 4, 2}, solution.resultArray(new int[]{5, 4, 3, 2, 1}), "strictly decreasing");
        // 含上限值 100 的场景。
        assertEquals(new int[]{100, 99, 2, 1}, solution.resultArray(new int[]{100, 1, 99, 2}), "max value 100");
        System.out.println("leet#3069 passed");
    }
}
