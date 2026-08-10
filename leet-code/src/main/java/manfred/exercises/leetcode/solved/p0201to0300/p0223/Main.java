package manfred.exercises.leetcode.solved.p0201to0300.p0223;

/** 题目链接：https://leetcode.cn/problems/rectangle-area/ */

/**
 * LeetCode 第 223 题「矩形面积」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(solution.computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
    }
}
