/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,1,2,3,3],

Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

 */

package manfred.exercises.leetcode.solved.p0001to0100.p0080;

import static manfred.exercises.assertion.Assert.assertArrayEquals;
import static manfred.exercises.assertion.Assert.assertEquals;

/** 题目链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/ */

/**
 * LeetCode 第 80 题「删除有序数组中的重复项 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution so = new Solution();
        // 题面示例 1：[1,1,1,2,2,3] -> 长度 5，前 5 个为 [1,1,2,2,3]
        int[] x = new int[]{1, 1, 1, 2, 2, 3};
        int len = so.removeDuplicates(x);
        assertEquals(5, len);
        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, java.util.Arrays.copyOf(x, len));

        // 题面示例 2：[0,0,1,1,1,1,2,3,3] -> 长度 7，前 7 个为 [0,0,1,1,2,3,3]
        x = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        len = so.removeDuplicates(x);
        assertEquals(7, len);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 3, 3}, java.util.Arrays.copyOf(x, len));
        System.out.println("passed");
    }
}
