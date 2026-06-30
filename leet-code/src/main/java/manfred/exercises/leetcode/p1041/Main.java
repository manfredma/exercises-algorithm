package manfred.exercises.leetcode.p1041;

/*
在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:

    北方向 是y轴的正方向。
    南方向 是y轴的负方向。
    东方向 是x轴的正方向。
    西方向 是x轴的负方向。

机器人可以接受下列三条指令之一：

    "G"：直走 1 个单位
    "L"：左转 90 度
    "R"：右转 90 度

机器人按顺序执行指令 instructions，并一直重复它们。

只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。

提示：
    1 <= instructions.length <= 100
    instructions[i] 仅包含 'G', 'L', 'R'
*/
/**
 * LeetCode 第 1041 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: instructions = "GGLLGG" → 期望 true
        System.out.println(solution.isRobotBounded("GGLLGG"));
        // 示例 2: instructions = "GG" → 期望 false
        System.out.println(solution.isRobotBounded("GG"));
        // 示例 3: instructions = "GL" → 期望 true
        System.out.println(solution.isRobotBounded("GL"));
    }
}
