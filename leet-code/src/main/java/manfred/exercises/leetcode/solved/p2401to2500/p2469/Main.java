package manfred.exercises.leetcode.solved.p2401to2500.p2469;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/convert-the-temperature/ */

/*
给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以摄氏度(Celsius)为单位。
你需要将摄氏度转换为开氏度(Kelvin)和华氏度(Fahrenheit)，
并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
注意：
  开氏度 = 摄氏度 + 273.15
  华氏度 = 摄氏度 * 1.80 + 32.00
*/
/**
 * LeetCode 第 2469 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: celsius = 36.50 → 期望 [309.65000, 97.70000]
        double[] res1 = solution.convertTemperature(36.50);
        assertEquals(309.65, res1[0]);
        assertEquals(97.7, res1[1]);
        // 示例 2: celsius = 122.11 → 期望 [395.26000, 251.79800]
        double[] res2 = solution.convertTemperature(122.11);
        assertEquals(395.26, res2[0]);
        assertEquals(251.798, res2[1]);
        System.out.println("passed");
    }
}
