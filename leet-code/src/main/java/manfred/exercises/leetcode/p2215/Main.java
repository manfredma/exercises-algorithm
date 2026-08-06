package manfred.exercises.leetcode.p2215;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给你两个下标从 0 开始的整数数组 nums1 和 nums2，返回长度为 2 的列表 answer。
answer[0] 是 nums1 中不存在于 nums2 中的不同整数；answer[1] 反之。整数可按任意顺序返回。

示例 1：nums1 = [1,2,3], nums2 = [2,4,6]，输出：[[1,3],[4,6]]。
示例 2：nums1 = [1,2,3,3], nums2 = [1,1,2,2]，输出：[[3],[]]。

提示：1 <= nums1.length, nums2.length <= 1000；-1000 <= nums1[i], nums2[i] <= 1000。
*/
/** LeetCode 第 2215 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        assertAnswer(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(4, 6)),
                solution.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        assertAnswer(Arrays.asList(Arrays.asList(3), Arrays.<Integer>asList()),
                solution.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
        assertAnswer(Arrays.asList(Arrays.asList(1), Arrays.asList(2)),
                solution.findDifference(new int[]{1}, new int[]{2, 2}));
    }

    private static void assertAnswer(List<List<Integer>> expected, List<List<Integer>> actual) {
        if (!toSets(expected).equals(toSets(actual)) || !hasDistinctValues(actual)) {
            throw new AssertionError("expected: " + expected + ", actual: " + actual);
        }
    }

    private static List<Set<Integer>> toSets(List<List<Integer>> values) {
        return Arrays.asList(new HashSet<>(values.get(0)), new HashSet<>(values.get(1)));
    }

    private static boolean hasDistinctValues(List<List<Integer>> values) {
        for (List<Integer> value : values) {
            if (new HashSet<>(value).size() != value.size()) {
                return false;
            }
        }
        return true;
    }
}
