package manfred.exercises.leetcode.p1431;

/*
有 n 个孩子，candies[i] 是第 i 个孩子的糖果数，extraCandies 是额外糖果数。
若把所有额外糖果给第 i 个孩子后，他拥有最多糖果，则 result[i]=true。

示例 1：
输入：candies = [2,3,5,1,3], extraCandies = 3
输出：[true,true,true,false,true]

示例 2：
输入：candies = [4,2,1,1,2], extraCandies = 1
输出：[true,false,false,false,false]

示例 3：
输入：candies = [12,1,12], extraCandies = 10
输出：[true,false,true]

提示：
- 2 <= n <= 100
- 1 <= candies[i] <= 100
- 1 <= extraCandies <= 50
*/
/**
 * LeetCode 第 1431 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: candies=[2,3,5,1,3], extraCandies=3 → 期望 [true,true,true,false,true]
        System.out.println(solution.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        // 示例 2: candies=[4,2,1,1,2], extraCandies=1 → 期望 [true,false,false,false,false]
        System.out.println(solution.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        // 示例 3: candies=[12,1,12], extraCandies=10 → 期望 [true,false,true]
        System.out.println(solution.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }
}
