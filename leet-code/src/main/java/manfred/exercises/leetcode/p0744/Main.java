package manfred.exercises.leetcode.p0744;

/*
给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。
letters 里至少有两个不同的字符。
返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
*/
/**
 * LeetCode 第 744 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: letters = ['c', 'f', 'j'], target = 'a' → 期望 'c'
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        // 示例 2: letters = ['c','f','j'], target = 'c' → 期望 'f'
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        // 示例 3: letters = ['x','x','y','y'], target = 'z' → 期望 'x'
        System.out.println(solution.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'));
    }
}
