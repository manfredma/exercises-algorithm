package manfred.exercises.leetcode.p118;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 118 题「杨辉三角」：逐行计算，每个元素为上一行相邻两元素之和。
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < i - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }
        return result;
    }
}