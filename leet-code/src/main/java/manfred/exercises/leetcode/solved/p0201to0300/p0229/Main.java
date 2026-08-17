package manfred.exercises.leetcode.solved.p0201to0300.p0229;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.Arrays;

/** 题目链接：https://leetcode.cn/problems/majority-element-ii/ */

/**
 * 229. 多数元素 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: 题面 Output
        assertEquals(Arrays.asList(3), solution.majorityElement(new int[]{3, 2, 3}));
        // 自造用例: n=8, 阈值 ⌊8/3⌋=2, 3 与 2 各出现 3 次 > 2，候选顺序经 BM 投票后输出 [3,2]
        assertEquals(Arrays.asList(3, 2), solution.majorityElement(new int[]{3, 2, 3, 4, 3, 2, 2, 5}));
        // 示例 2: 题面 Output
        assertEquals(Arrays.asList(1), solution.majorityElement(new int[]{1}));
        // 示例 3: 题面 Output
        assertEquals(Arrays.asList(1, 2), solution.majorityElement(new int[]{1, 2}));
        System.out.println("p0229 passed");
    }
}
