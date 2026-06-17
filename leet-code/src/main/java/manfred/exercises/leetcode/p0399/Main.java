package manfred.exercises.leetcode.p0399;

import java.util.Arrays;
import java.util.List;

/*
给你一个变量对数组 equations 和一个实数值数组 values，其中 equations[i] = [Ai, Bi] 和
values[i] 共同表示等式 Ai / Bi = values[i]。

返回所有问题的答案。如果存在某个无法确定的答案，则用 -1.0 替代。

示例 1：
输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0],
      queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]

示例 2：
输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
      queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]

示例 3：
输入：equations = [["a","b"]], values = [0.5],
      queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]
*/
/**
 * LeetCode 第 399 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1 → 期望 [6.0, 0.5, -1.0, 1.0, -1.0]
        System.out.println(Arrays.toString(solution.calcEquation(
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
                new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"),
                        Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"))
        )));

        // 示例 2 → 期望 [3.75, 0.4, 5.0, 0.2]
        System.out.println(Arrays.toString(solution.calcEquation(
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")),
                new double[]{1.5, 2.5, 5.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("c", "b"),
                        Arrays.asList("bc", "cd"), Arrays.asList("cd", "bc"))
        )));

        // 示例 3 → 期望 [0.5, 2.0, -1.0, -1.0]
        System.out.println(Arrays.toString(solution.calcEquation(
                Arrays.asList(Arrays.asList("a", "b")),
                new double[]{0.5},
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"),
                        Arrays.asList("a", "c"), Arrays.asList("x", "y"))
        )));
    }
}
