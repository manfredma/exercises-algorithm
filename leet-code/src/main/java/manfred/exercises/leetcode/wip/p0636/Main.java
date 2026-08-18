package manfred.exercises.leetcode.wip.p0636;

import static manfred.exercises.assertion.Assert.*;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/exclusive-time-of-functions/ */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(new int[]{3, 4}, solution.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6")), "n=2, 4 logs");
        assertEquals(new int[]{8}, solution.exclusiveTime(1, Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")), "n=1, 6 logs");
        assertEquals(new int[]{7, 1}, solution.exclusiveTime(2, Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")), "n=2, 6 logs");
        System.out.println("leet#0636 passed");
    }
}
