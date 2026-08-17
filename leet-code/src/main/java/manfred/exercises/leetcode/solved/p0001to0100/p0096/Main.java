/*

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
package manfred.exercises.leetcode.solved.p0001to0100.p0096;

import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/unique-binary-search-trees/ */

/**
 * LeetCode 第 96 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例：n=3 时有 5 棵不同的 BST
        assertEquals(5, solution.numTrees(3));
        assertEquals(5, new Solution2().numTrees(3));

        // 手算：n=10 为卡塔兰数 C10 = 16796
        assertEquals(16796, solution.numTrees(10));
        assertEquals(16796, new Solution2().numTrees(10));
        System.out.println("passed");
    }
}
