package manfred.exercises.leetcode.solved.p3001to3100.p3069;

/**
 * 将元素分配到两个数组中 I（LeetCode 3069）。
 *
 * <p>解法：原地双端填充，输出数组 result 同时承载 arr1 与 arr2，额外空间 O(1)。
 * arr1 从 result 左端正向增长（result[0] = nums[0]），arr2 从右端逆向增长
 * （result[len-1] = nums[1]）。left 指向 arr1 当前末尾下标，right 指向 arr2 当前
 * 末尾下标。第 i 次操作比较两者末尾大小：arr1 末尾大则 nums[i] 入 arr1
 * （result[++left]），否则入 arr2（result[--right]）。循环结束后 arr1 段正序、
 * arr2 段逆序，反转右半段即得 arr1 ++ arr2。
 *
 * <p>时间复杂度 O(n)，空间复杂度 O(1)（输出数组不计）。
 *
 * @see <a href="https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/">LeetCode 中文站</a>
 */
class Solution {
    public int[] resultArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = nums[0];
        result[len - 1] = nums[1];
        int left = 0, right = len - 1;
        for (int i = 2; i < len; i++) {
            if (result[left] > result[right]) {
                result[++left] = nums[i];
            } else {
                result[--right] = nums[i];
            }
        }

        // 反转一下后半部分
        for (int i = right; i < right + (len - right) / 2; i++) {
            int revIdx = len - (i - right) - 1;
            int tmp = result[i];
            result[i] = result[revIdx];
            result[revIdx] = tmp;
        }

        return result;
    }
}
