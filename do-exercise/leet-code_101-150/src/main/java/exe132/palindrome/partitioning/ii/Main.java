/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

 */
package exe132.palindrome.partitioning.ii;

/**
 * LeetCode 第 132 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCut("aab"));
        System.out.println(solution.minCut("abcde"));
        System.out.println(solution.minCut("aa"));
    }
}
