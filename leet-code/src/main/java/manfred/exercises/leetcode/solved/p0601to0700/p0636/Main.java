package manfred.exercises.leetcode.solved.p0601to0700.p0636;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/exclusive-time-of-functions/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertExclusiveTime(new int[]{3, 4}, 2,
                Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"), solution, solution2, "example 1");
        assertExclusiveTime(new int[]{8}, 1,
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"), solution, solution2, "example 2");
        assertExclusiveTime(new int[]{7, 1}, 2,
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"), solution, solution2, "example 3");
        assertExclusiveTime(new int[]{1}, 1,
                Arrays.asList("0:start:0", "0:end:0"), solution, solution2, "single instant call");
        assertExclusiveTime(new int[]{1, 2}, 2,
                Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:2"), solution, solution2, "sequential top-level calls");
        System.out.println("leet#0636 passed");
    }

    private static void assertExclusiveTime(int[] expected, int n, List<String> logs,
                                            Solution solution, Solution2 solution2, String desc) {
        assertEquals(expected, solution.exclusiveTime(n, logs), "Solution " + desc);
        assertEquals(expected, solution2.exclusiveTime(n, logs), "Solution2 " + desc);
    }
}
