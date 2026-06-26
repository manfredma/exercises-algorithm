package manfred.exercises.leetcode.p0712;

/*
给定两个字符串 s1 和 s2，返回使两个字符串相等所需删除字符的 ASCII 值的最小和。
提示：1 <= s1.length, s2.length <= 1000，s1 和 s2 由小写英文字母组成。
*/
/**
 * LeetCode 第 712 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: s1 = "sea", s2 = "eat" → 期望 231
        System.out.println(solution.minimumDeleteSum("sea", "eat"));

        // 示例 2: s1 = "delete", s2 = "leet" → 期望 403
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }
}
