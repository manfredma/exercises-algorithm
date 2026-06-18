package manfred.exercises.leetcode.p0433;

/*
基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
一次基因变化就意味着这个基因序列中的一个字符发生了变化，且变化后的基因必须位于基因库中。

给你两个基因序列 start 和 end，以及一个基因库 bank，
返回能够使 start 变化为 end 所需的最少变化次数，如果无法完成则返回 -1。

示例 1：
输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
输出：1

示例 2：
输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
输出：2

示例 3：
输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
输出：3

提示：
- start.length == 8，end.length == 8
- 0 <= bank.length <= 10
- start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
*/
/**
 * LeetCode 第 433 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1 → 期望 1
        System.out.println(solution.minMutation("AACCGGTT", "AACCGGTA",
                new String[]{"AACCGGTA"}));

        // 示例 2 → 期望 2
        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA",
                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));

        // 示例 3 → 期望 3
        System.out.println(solution.minMutation("AAAAACCC", "AACCCCCC",
                new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
