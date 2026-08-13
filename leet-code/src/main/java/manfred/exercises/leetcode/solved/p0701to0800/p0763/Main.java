package manfred.exercises.leetcode.solved.p0701to0800.p0763;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/partition-labels/ */

/*
给你一个字符串 s。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
返回一个表示每个字符串片段的长度的列表。

示例 1：

输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]

示例 2：

输入：s = "eccbbbbdec"
输出：[10]
*/
/**
 * LeetCode 第 763 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        // 示例 1: s = "ababcbacadefegdehijhklij" → 期望 [9,7,8]
        assertListEquals(Arrays.asList(9, 7, 8), solution.partitionLabels("ababcbacadefegdehijhklij"));
        assertListEquals(Arrays.asList(9, 7, 8), solution2.partitionLabels("ababcbacadefegdehijhklij"));
        assertListEquals(Arrays.asList(9, 7, 8), solution3.partitionLabels("ababcbacadefegdehijhklij"));
        // 示例 2: s = "eccbbbbdec" → 期望 [10]
        assertListEquals(Arrays.asList(10), solution.partitionLabels("eccbbbbdec"));
        assertListEquals(Arrays.asList(10), solution2.partitionLabels("eccbbbbdec"));
        assertListEquals(Arrays.asList(10), solution3.partitionLabels("eccbbbbdec"));
        // 边界: 单字符 → 期望 [1]
        assertListEquals(Arrays.asList(1), solution.partitionLabels("a"));
        assertListEquals(Arrays.asList(1), solution2.partitionLabels("a"));
        assertListEquals(Arrays.asList(1), solution3.partitionLabels("a"));
        // 边界: 每个字符都不同 → 期望每段长度 1
        assertListEquals(Arrays.asList(1, 1, 1), solution.partitionLabels("abc"));
        assertListEquals(Arrays.asList(1, 1, 1), solution2.partitionLabels("abc"));
        assertListEquals(Arrays.asList(1, 1, 1), solution3.partitionLabels("abc"));
    }

    private static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
