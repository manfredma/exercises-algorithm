package manfred.exercises.leetcode.p2469;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(solution.convertTemperature(36.50)));
        // 示例 2: celsius = 122.11 → 期望 [395.26000, 251.79800]
        System.out.println(Arrays.toString(solution.convertTemperature(122.11)));
    }
}
