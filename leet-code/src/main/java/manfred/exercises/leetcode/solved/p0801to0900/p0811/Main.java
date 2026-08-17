package manfred.exercises.leetcode.solved.p0801to0900.p0811;

import static manfred.exercises.assertion.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/subdomain-visit-count/ */

/**
 * LeetCode 第 811 题（子域名访问计数）的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 *Output:
 * ["901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org", "1 intel.mail.com",
 *"951 com"]
        */
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        // 结果为无序集合，排序后比对
        List<String> expected = new ArrayList<>(Arrays.asList(
                "901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org",
                "5 org", "1 intel.mail.com", "951 com"));
        List<String> actual = new ArrayList<>(solution.subdomainVisits(cpdomains));
        Collections.sort(expected);
        Collections.sort(actual);
        assertEquals(expected, actual);

        System.out.println("p0811 passed");
    }
}
