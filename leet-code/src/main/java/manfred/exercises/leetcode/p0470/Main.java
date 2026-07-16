package manfred.exercises.leetcode.p0470;

/*
给定方法 rand7 可生成 [1,7] 范围内的均匀随机整数，试写 rand10 生成 [1,10] 范围内的均匀随机整数。
只能调用 rand7()，不能调用 Math.random()。每个测试用例有一个内部参数 n，表示 rand10() 被调用的次数。

示例 1: 输入 1, 输出 [2]
示例 2: 输入 2, 输出 [2,8]
示例 3: 输入 3, 输出 [3,8,10]

进阶: rand7() 调用次数的期望是多少？能否尽量少调用？
*/
/**
 * LeetCode 第 470 题的测试入口。
 *
 * <p>由于 rand10() 输出随机，无法用固定期望值断言单次结果，
 * 这里通过大样本统计 [1,10] 各值频率，验证均匀性。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例展示：调用 3 次（对应示例 3 的 n=3，具体值随机）
        System.out.print("调用 3 次: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(solution.rand10() + " ");
        }
        System.out.println();

        // 均匀性验证：大样本统计各值频率，期望均接近 0.1
        int n = 1000000;
        int[] count = new int[11];
        int calls = 0;
        for (int i = 0; i < n; i++) {
            count[solution.rand10()]++;
        }
        System.out.println("样本数=" + n + "，各值频率：");
        for (int v = 1; v <= 10; v++) {
            System.out.printf("  %2d: %.4f%n", v, count[v] / (double) n);
        }
        double expected = 1.0 / 10;
        boolean uniform = true;
        for (int v = 1; v <= 10; v++) {
            if (Math.abs(count[v] / (double) n - expected) > 0.002) {
                uniform = false;
                break;
            }
        }
        System.out.println(uniform ? "均匀性 OK ✅" : "均匀性 FAIL ❌");
    }
}
