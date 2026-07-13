package manfred.exercises.leetcode.p1534;

/*
给你一个整数数组 arr，以及 a、b、c 三个整数。请你统计其中好三元组的数量。
如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件,则认为它是一个好三元组:
  0 <= i < j < k < arr.length
  |arr[i] - arr[j]| <= a
  |arr[j] - arr[k]| <= b
  |arr[i] - arr[k]| <= c
返回好三元组的数量。
*/
/**
 * LeetCode 第 1534 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3 → 期望 4
        System.out.println(solution.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        // 示例 2: arr = [1,1,2,2,3], a = 0, b = 0, c = 1 → 期望 0
        System.out.println(solution.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }
}
