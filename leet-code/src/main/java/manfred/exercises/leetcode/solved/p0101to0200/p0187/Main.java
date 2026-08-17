/*

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

 */
package manfred.exercises.leetcode.solved.p0101to0200.p0187;

import static manfred.exercises.assertion.Assert.assertEquals;
import static manfred.exercises.assertion.Assert.assertTrue;

/** 题目链接：https://leetcode.cn/problems/repeated-dna-sequences/ */

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 第 187 题的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" -> ["AAAAACCCCC","CCCCCAAAAA"]
        // 结果源自 HashSet，顺序不定，用 size + containsAll 验证
        List<String> result = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
        assertEquals(2, result.size());
        assertTrue(result.containsAll(expected));
        System.out.println("p0187 passed");
    }
}
