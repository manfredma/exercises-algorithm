package manfred.exercises.leetcode.solved.p0901to1000.p0916;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/word-subsets/ */

/**
 * LeetCode 第 916 题（单词子集）的测试入口，验证三种解法的正确性。
 */
public class Main {
    public static void main(String[] args) {
        String[] words1 = new String[]{"amazon", "apple", "facebook", "google", "leetcode"};

        // 三种解法在 5 组用例上的期望输出（保持 words1 出现顺序）
        String[][] b = {
                {"e", "o"},
                {"l", "e"},
                {"e", "oo"},
                {"lo", "eo"},
                {"ec", "oc", "ceo"}
        };
        @SuppressWarnings("unchecked")
        List<String>[] expected = new List[]{
                Arrays.asList("facebook", "google", "leetcode"),
                Arrays.asList("apple", "google", "leetcode"),
                Arrays.asList("facebook", "google"),
                Arrays.asList("google", "leetcode"),
                Arrays.asList("facebook", "leetcode")
        };

        Solution solution = new Solution();
        for (int i = 0; i < b.length; i++) {
            assertEquals(expected[i], solution.wordSubsets(words1, b[i]));
        }

        Solution2 solution2 = new Solution2();
        for (int i = 0; i < b.length; i++) {
            assertEquals(expected[i], solution2.wordSubsets(words1, b[i]));
        }

        Solution3 solution3 = new Solution3();
        for (int i = 0; i < b.length; i++) {
            assertEquals(expected[i], solution3.wordSubsets(words1, b[i]));
        }

        System.out.println("p0916 passed");
    }
}
