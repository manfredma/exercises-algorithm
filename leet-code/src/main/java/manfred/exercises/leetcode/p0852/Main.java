package manfred.exercises.leetcode.p0852;

/*
给定一个长度为 n 的整数山脉数组 arr，其中的值递增到一个峰值元素然后递减。
返回峰值元素的下标。要求 O(log n) 时间复杂度。
*/
/**
 * LeetCode 第 852 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: arr = [0,1,0] → 期望 1
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        // 示例 2: arr = [0,2,1,0] → 期望 1
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        // 示例 3: arr = [0,10,5,2] → 期望 1
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
    }
}
