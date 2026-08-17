/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it to the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
package manfred.exercises.leetcode.solved.p0001to0100.p0031;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/next-permutation/ */

/**
 * LeetCode 第 31 题「下一个排列」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 3, 2}, nums);

        nums = new int[]{3, 2, 1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 2, 3}, nums);

        nums = new int[]{1, 1, 5};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{1, 5, 1}, nums);

        nums = new int[]{1, 3, 2};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 1, 3}, nums);

        nums = new int[]{2, 2, 7, 5, 4, 3, 2, 2, 1};
        solution.nextPermutation(nums);
        assertArrayEquals(new int[]{2, 3, 1, 2, 2, 2, 4, 5, 7}, nums);
        System.out.println("p0031 passed");
    }
}
