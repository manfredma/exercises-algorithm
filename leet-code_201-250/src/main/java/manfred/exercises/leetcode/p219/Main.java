package manfred.exercises.leetcode.p219;

/**
 * LeetCode 第 219 题「存在重复元素 II」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        /*
         * Example 1:
         * <p>
         * Input: nums = [1,2,3,1], k = 3
         * Output: true
         * Example 2:
         * <p>
         * Input: nums = [1,0,1,1], k = 1
         * Output: true
         * Example 3:
         * <p>
         * Input: nums = [1,2,3,1,2,3], k = 2
         * Output: false
         */
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
