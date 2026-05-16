package manfred.exercises.leetcode.p119;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 119 题「杨辉三角 II」：滚动数组，从后向前更新一维数组。
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            return result;
        }
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        if (rowIndex == 1) {
            return pre;
        }
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < i - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1));
            }
            cur.add(1);
            result = cur;
            pre = cur;
        }
        return result;
    }
}