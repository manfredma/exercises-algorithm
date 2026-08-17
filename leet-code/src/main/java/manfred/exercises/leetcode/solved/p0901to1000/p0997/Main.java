package manfred.exercises.leetcode.solved.p0901to1000.p0997;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/find-the-town-judge/ */

/*
小镇里有 n 个人，按从 1 到 n 的顺序编号。传言称，这些人中有一个暗地里是小镇法官。

如果小镇法官真的存在，那么：

- 小镇法官不会信任任何人。
- 每个人（除了小镇法官）都信任这位小镇法官。
- 只有一个人同时满足属性 1 和属性 2。

给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。

如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。

示例 1：

输入：n = 2, trust = [[1,2]]
输出：2

示例 2：

输入：n = 3, trust = [[1,3],[2,3]]
输出：3

示例 3：

输入：n = 3, trust = [[1,3],[2,3],[3,1]]
输出：-1

提示：

1 <= n <= 1000

0 <= trust.length <= 10^4

trust[i].length == 2

trust 中的所有 trust[i] = [ai, bi] 互不相同

ai != bi

1 <= ai, bi <= n
*/
/**
 * LeetCode 第 997 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 示例 1: n = 2, trust = [[1,2]] → 期望 2
        assertEquals(2, solution.findJudge(2, new int[][]{{1, 2}}));
        // 示例 2: n = 3, trust = [[1,3],[2,3]] → 期望 3
        assertEquals(3, solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        // 示例 3: n = 3, trust = [[1,3],[2,3],[3,1]] → 期望 -1
        assertEquals(-1, solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        // 边界: n = 1, trust = [] → 期望 1（唯一的人天然是法官）
        assertEquals(1, solution.findJudge(1, new int[][]{}));
        // 边界: n = 3, trust = [] → 期望 -1（无人被信任，无法确定法官）
        assertEquals(-1, solution.findJudge(3, new int[][]{}));
        // 边界: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]] → 期望 3
        assertEquals(3, solution.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }

}
