package manfred.exercises.leetcode.solved.p0201to0300.p0278;

/*
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，产品的最新版本没有通过质量检测。
由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设有 n 个版本 [1, 2, ..., n]，找出导致之后所有版本出错的第一个错误版本。

可以调用 bool isBadVersion(version) 接口判断版本号 version 是否错误。实现函数来查找第一个错误的版本，
并尽量减少 API 调用次数。

示例 1：
输入：n = 5, bad = 4
输出：4
解释：
调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true
所以，4 是第一个错误的版本。

示例 2：
输入：n = 1, bad = 1
输出：1

提示：
1 <= bad <= n <= 2^31 - 1
*/
/** LeetCode 第 278 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        assertEquals(4, new Solution(4).firstBadVersion(5));
        assertEquals(1, new Solution(1).firstBadVersion(1));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("期望：" + expected + "，实际：" + actual);
        }
        System.out.println("通过：" + expected);
    }
}
