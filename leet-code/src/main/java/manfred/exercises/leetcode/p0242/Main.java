package manfred.exercises.leetcode.p0242;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1：
输入：s = "anagram", t = "nagaram"
输出：true

示例 2：
输入：s = "rat", t = "car"
输出：false

提示：
- 1 <= s.length, t.length <= 5 * 10^4
- s 和 t 仅包含小写字母

进阶：如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/
/**
 * LeetCode 第 242 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: s = "anagram", t = "nagaram" → 期望 true
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        // 示例 2: s = "rat", t = "car" → 期望 false
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
