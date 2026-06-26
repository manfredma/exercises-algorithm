package manfred.exercises.leetcode.p0682;

import java.util.Arrays;

/*
你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，
过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，
其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
  整数 x  — 表示本回合新获得分数 x
  "+"     — 本回合得分是前两次得分的总和
  "D"     — 本回合得分是前一次得分的两倍
  "C"     — 前一次得分无效，将其移除

请你返回记录中所有得分的总和。
提示：1 <= ops.length <= 1000，整数范围 [-3*10^4, 3*10^4]
*/
/**
 * LeetCode 第 682 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: ["5","2","C","D","+"] → 期望 30
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));

        // 示例 2: ["5","-2","4","C","D","9","+","+"] → 期望 27
        System.out.println(solution.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

        // 示例 3: ["1"] → 期望 1
        System.out.println(solution.calPoints(new String[]{"1"}));
    }
}
