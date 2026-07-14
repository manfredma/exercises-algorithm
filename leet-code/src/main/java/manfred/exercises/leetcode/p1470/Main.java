package manfred.exercises.leetcode.p1470;

import java.util.Arrays;

/*
给你一个数组 nums，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
*/
/**
 * LeetCode 第 1470 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: nums = [2,5,1,3,4,7], n = 3 → 期望 [2,3,5,4,1,7]
        System.out.println(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        // 示例 2: nums = [1,2,3,4,4,3,2,1], n = 4 → 期望 [1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(solution.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
        // 示例 3: nums = [1,1,2,2], n = 2 → 期望 [1,2,1,2]
        System.out.println(Arrays.toString(solution.shuffle(new int[]{1, 1, 2, 2}, 2)));
    }
}
