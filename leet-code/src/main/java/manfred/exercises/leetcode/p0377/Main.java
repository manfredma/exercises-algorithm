package manfred.exercises.leetcode.p0377;

/*
给你一个由不同整数组成的数组 nums 和一个目标整数 target。
从 nums 中找出总和为 target 的元素组合的个数。
注意:顺序不同的序列被视作不同的组合。
*/
/**
 * LeetCode 第 377 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums = [1,2,3], target = 4 → 期望 7
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
        // 示例 2: nums = [9], target = 3 → 期望 0
        System.out.println(solution.combinationSum4(new int[]{9}, 3));
    }
}
