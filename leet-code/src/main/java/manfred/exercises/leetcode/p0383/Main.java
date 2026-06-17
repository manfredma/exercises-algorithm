package manfred.exercises.leetcode.p0383;

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。

示例 1：
输入：ransomNote = "a", magazine = "b"
输出：false

示例 2：
输入：ransomNote = "aa", magazine = "ab"
输出：false

示例 3：
输入：ransomNote = "aa", magazine = "aab"
输出：true

提示：
- 1 <= ransomNote.length, magazine.length <= 10^5
- ransomNote 和 magazine 由小写英文字母组成
*/
/**
 * LeetCode 第 383 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: ransomNote = "a", magazine = "b" → 期望 false
        System.out.println(solution.canConstruct("a", "b"));
        // 示例 2: ransomNote = "aa", magazine = "ab" → 期望 false
        System.out.println(solution.canConstruct("aa", "ab"));
        // 示例 3: ransomNote = "aa", magazine = "aab" → 期望 true
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}
