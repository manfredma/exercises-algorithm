/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
package manfred.exercises.leetcode.solved.p0401to0500.p0442;

import static manfred.exercises.assertion.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array/ */

/**
 * LeetCode 第 442 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例: [4,3,2,7,8,2,3,1] → 期望 [2,3]（顺序任意）
        List<Integer> result = solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> expected = Arrays.asList(2, 3);
        assertTrue(result.containsAll(expected) && result.size() == expected.size(),
                "findDuplicates 期望包含 [2,3]，实际 " + result);
        System.out.println("p0442 passed");
    }
}
