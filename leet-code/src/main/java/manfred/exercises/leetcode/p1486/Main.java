package manfred.exercises.leetcode.p1486;

/*
给你两个整数 n 和 start。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length。
请返回 nums 中所有元素按位异或(XOR)后得到的结果。
*/
/**
 * LeetCode 第 1486 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 5, start = 0 → 期望 8
        System.out.println(solution.xorOperation(5, 0));
        // 示例 2: n = 4, start = 3 → 期望 8
        System.out.println(solution.xorOperation(4, 3));
        // 示例 3: n = 1, start = 7 → 期望 7
        System.out.println(solution.xorOperation(1, 7));
        // 示例 4: n = 10, start = 5 → 期望 2
        System.out.println(solution.xorOperation(10, 5));
    }
}
