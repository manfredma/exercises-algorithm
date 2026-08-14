package manfred.exercises.leetcode.solved.p0201to0300.p0207;

/** 题目链接：https://leetcode.cn/problems/course-schedule/ */

/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1。

在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]，
表示如果要学习课程 ai 则 必须 先学习课程 bi。

请你判断是否可能完成所有课程的学习？如果可以，返回 true；否则，返回 false。

示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true

示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false

提示：

1 <= numCourses <= 2000

0 <= prerequisites.length <= 5000

prerequisites[i].length == 2

0 <= ai, bi < numCourses

prerequisites[i] 中的所有课程对 互不相同
*/
/**
 * LeetCode 第 207 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Solution4 solution4 = new Solution4();
        // 示例 1: numCourses=2, prerequisites=[[1,0]] → 期望 true
        assertEquals(true, solution.canFinish(2, new int[][]{{1, 0}}));
        assertEquals(true, solution2.canFinish(2, new int[][]{{1, 0}}));
        assertEquals(true, solution3.canFinish(2, new int[][]{{1, 0}}));
        assertEquals(true, solution4.canFinish(2, new int[][]{{1, 0}}));
        // 示例 2: numCourses=2, prerequisites=[[1,0],[0,1]] → 期望 false（二元环）
        assertEquals(false, solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertEquals(false, solution2.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertEquals(false, solution3.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertEquals(false, solution4.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        // 边界: 无先修课程 → 期望 true
        assertEquals(true, solution.canFinish(3, new int[][]{}));
        assertEquals(true, solution2.canFinish(3, new int[][]{}));
        assertEquals(true, solution3.canFinish(3, new int[][]{}));
        assertEquals(true, solution4.canFinish(3, new int[][]{}));
        // 边界: 单门课程 → 期望 true
        assertEquals(true, solution.canFinish(1, new int[][]{}));
        assertEquals(true, solution2.canFinish(1, new int[][]{}));
        assertEquals(true, solution3.canFinish(1, new int[][]{}));
        assertEquals(true, solution4.canFinish(1, new int[][]{}));
        // 边界: 长链无环 → 期望 true
        assertEquals(true, solution.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        assertEquals(true, solution2.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        assertEquals(true, solution3.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        assertEquals(true, solution4.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
        // 边界: DAG 多路径指向同节点（0→2 与 1→2）→ 期望 true（非环，兄弟分支共享后继）
        assertEquals(true, solution.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        assertEquals(true, solution2.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        assertEquals(true, solution3.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        assertEquals(true, solution4.canFinish(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        // 边界: 三元环 → 期望 false
        assertEquals(false, solution.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        assertEquals(false, solution2.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        assertEquals(false, solution3.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        assertEquals(false, solution4.canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        // 边界: 部分有环（0↔1 成环，2→3 无关）→ 期望 false
        assertEquals(false, solution.canFinish(4, new int[][]{{1, 0}, {0, 1}, {2, 3}}));
        assertEquals(false, solution2.canFinish(4, new int[][]{{1, 0}, {0, 1}, {2, 3}}));
        assertEquals(false, solution3.canFinish(4, new int[][]{{1, 0}, {0, 1}, {2, 3}}));
        assertEquals(false, solution4.canFinish(4, new int[][]{{1, 0}, {0, 1}, {2, 3}}));
        // 边界: 菱形依赖无环（0→1, 0→2, 1→3, 2→3）→ 期望 true
        assertEquals(true, solution.canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        assertEquals(true, solution2.canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        assertEquals(true, solution3.canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
        assertEquals(true, solution4.canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
    }

    private static void assertEquals(boolean expected, boolean actual) {
        if (expected != actual) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }
}
