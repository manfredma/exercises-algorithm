package manfred.exercises.leetcode.p0374;

/*
我们正在玩猜数字游戏。我会从 1 到 n 随机选择一个数字，请你猜出是哪个数字。
猜错时会通过预定义接口 guess(int num) 提示：-1 表示猜大了，1 表示猜小了，0 表示猜中。
返回选出的数字。

示例 1: 输入 n = 10, pick = 6, 输出 6
示例 2: 输入 n = 1, pick = 1, 输出 1
示例 3: 输入 n = 2, pick = 1, 输出 1
*/
/**
 * LeetCode 第 374 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        // 示例 1: 输入 n = 10, pick = 6 → 期望 6
        System.out.println(new Solution(6).guessNumber(10));
        // 示例 2: 输入 n = 1, pick = 1 → 期望 1
        System.out.println(new Solution(1).guessNumber(1));
        // 示例 3: 输入 n = 2, pick = 1 → 期望 1
        System.out.println(new Solution(1).guessNumber(2));
    }
}
