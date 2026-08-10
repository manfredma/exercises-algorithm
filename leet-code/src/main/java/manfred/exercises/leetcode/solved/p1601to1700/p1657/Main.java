package manfred.exercises.leetcode.solved.p1601to1700.p1657;

/** 题目链接：https://leetcode.cn/problems/determine-if-two-strings-are-close/ */

/*
如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：

操作 1：交换任意两个 现有 字符。

例如，abcde -> aecdb

操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。

例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）

你可以根据需要对任意一个字符串多次使用这两种操作。

给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。

示例 1：

输入：word1 = "abc", word2 = "bca"
输出：true
解释：2 次操作从 word1 获得 word2 。
执行操作 1："abc" -> "acb"
执行操作 1："acb" -> "bca"

示例 2：

输入：word1 = "a", word2 = "aa"
输出：false
解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。

示例 3：

输入：word1 = "cabbba", word2 = "abbccc"
输出：true
解释：3 次操作从 word1 获得 word2 。
执行操作 1："cabbba" -> "caabbb"
执行操作 2："caabbb" -> "baaccc"
执行操作 2："baaccc" -> "abbccc"

提示：

1 <= word1.length, word2.length <= 10^5

word1 和 word2 仅包含小写英文字母
*/
/** LeetCode 第 1657 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(true, solution.closeStrings("abc", "bca"));
        assertEquals(false, solution.closeStrings("a", "aa"));
        assertEquals(true, solution.closeStrings("cabbba", "abbccc"));
        assertEquals(false, solution.closeStrings("cabbba", "aabbss"));
        assertEquals(true, solution.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbbbbccccdddeeff"));
        assertEquals(false, solution.closeStrings("a", "b"));
        assertEquals(false, solution.closeStrings("aaabbc", "aaaabc"));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) throw new AssertionError();
    }
}
