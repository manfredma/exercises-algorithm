package manfred.exercises.leetcode.solved.p0601to0700.p0657;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/robot-return-to-origin/ */

/*
在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。

移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。

如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。

注意：机器人"面朝"的方向无关紧要。"R" 将始终使机器人向右移动一次，"L" 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。

提示：
- 1 <= moves.length <= 2 * 10^4
- moves 只包含字符 'U', 'D', 'L' 和 'R'
*/
/**
 * LeetCode 第 657 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: moves = "UD" → 期望 true
        assertTrue(solution.judgeCircle("UD"));
        // 示例 2: moves = "LL" → 期望 false
        assertFalse(solution.judgeCircle("LL"));

        System.out.println("p0657 passed");
    }
}
