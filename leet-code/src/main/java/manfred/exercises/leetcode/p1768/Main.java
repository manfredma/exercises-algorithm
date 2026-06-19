package manfred.exercises.leetcode.p1768;

/*
给你两个字符串 word1 和 word2，从 word1 开始交替添加字母合并字符串。
如果一个字符串比另一个长，多出的字母追加到末尾。

示例 1：
输入：word1 = "abc", word2 = "pqr"
输出："apbqcr"

示例 2：
输入：word1 = "ab", word2 = "pqrs"
输出："apbqrs"

示例 3：
输入：word1 = "abcd", word2 = "pq"
输出："apbqcd"

提示：
- 1 <= word1.length, word2.length <= 100
- word1 和 word2 由小写英文字母组成
*/
/**
 * LeetCode 第 1768 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: word1="abc", word2="pqr" → 期望 "apbqcr"
        System.out.println(solution.mergeAlternately("abc", "pqr"));
        // 示例 2: word1="ab", word2="pqrs" → 期望 "apbqrs"
        System.out.println(solution.mergeAlternately("ab", "pqrs"));
        // 示例 3: word1="abcd", word2="pq" → 期望 "apbqcd"
        System.out.println(solution.mergeAlternately("abcd", "pq"));
    }
}
