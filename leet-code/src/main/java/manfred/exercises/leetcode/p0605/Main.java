package manfred.exercises.leetcode.p0605;

/*
假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，
其中 0 表示没种植花，1 表示种植了花。另有一个数 n，
能否在不打破种植规则的情况下种入 n 朵花？能则返回 true，不能则返回 false。
提示：1 <= flowerbed.length <= 2*10^4，0 <= n <= flowerbed.length
*/
/**
 * LeetCode 第 605 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1: flowerbed = [1,0,0,0,1], n = 1 → 期望 true
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));

        // 示例 2: flowerbed = [1,0,0,0,1], n = 2 → 期望 false
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
