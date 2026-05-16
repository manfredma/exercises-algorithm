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
package manfred.exercises.leetcode.p0096;

/**
 * LeetCode 第 96 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
        System.out.println(new Solution2().numTrees(3));

        System.out.println(solution.numTrees(10));
        System.out.println(new Solution2().numTrees(10));
    }
}
