package manfred.exercises.leetcode.p2466;

/*
给你整数 zero、one、low 和 high，从空字符串开始构造字符串：
- 将 '0' 在末尾添加 zero 次
- 将 '1' 在末尾添加 one 次
以上操作可执行任意次。长度在 [low, high] 之间的字符串称为「好字符串」。
返回不同好字符串的数目，结果对 10^9 + 7 取余。

示例 1:
输入：low = 3, high = 3, zero = 1, one = 1
输出：8

示例 2:
输入：low = 2, high = 3, zero = 1, one = 2
输出：5
*/
/**
 * LeetCode 第 2466 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 输入 low = 3, high = 3, zero = 1, one = 1 → 期望 8
        System.out.println(solution.countGoodStrings(3, 3, 1, 1));
        // 示例 2: 输入 low = 2, high = 3, zero = 1, one = 2 → 期望 5
        System.out.println(solution.countGoodStrings(2, 3, 1, 2));
    }
}
