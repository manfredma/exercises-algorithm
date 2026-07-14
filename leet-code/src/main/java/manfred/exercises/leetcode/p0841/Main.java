package manfred.exercises.leetcode.p0841;

import java.util.Arrays;
import java.util.List;

/*
有 n 个房间，编号 0..n-1。最初除 0 号外都锁着。
进入房间可获得里面的钥匙(每把钥匙对应一个房间号)。
给你 rooms,rooms[i] 是 i 号房间的钥匙集合。能否进入所有房间?
*/
/**
 * LeetCode 第 841 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: rooms = [[1],[2],[3],[]] → 期望 true
        System.out.println(solution.canVisitAllRooms(Arrays.asList(
                Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        // 示例 2: rooms = [[1,3],[3,0,1],[2],[0]] → 期望 false
        System.out.println(solution.canVisitAllRooms(Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
    }
}
