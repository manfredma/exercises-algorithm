/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

 */
package manfred.exercises.leetcode.wip.p0093;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/restore-ip-addresses/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 第 93 题的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        assertIpEquals(Arrays.asList("0.0.0.0"), s.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("1.1.1.1"), s.restoreIpAddresses("1111"), "1111");
        assertIpEquals(Arrays.asList("255.255.255.255"), s.restoreIpAddresses("255255255255"), "255255255255");
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s.restoreIpAddresses("25525511135"), "25525511135");

        Solution2 s2 = new Solution2();
        assertIpEquals(Arrays.asList("1.1.1.1"), s2.restoreIpAddresses("1111"), "1111");
        assertIpEquals(Arrays.asList("0.0.0.0"), s2.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("255.255.255.255"), s2.restoreIpAddresses("255255255255"), "255255255255");
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s2.restoreIpAddresses("25525511135"), "25525511135");
        System.out.println("p0093 all assertions passed");
    }

    private static void assertIpEquals(List<String> expected, List<String> actual, String desc) {
        List<String> e = new ArrayList<>(expected);
        List<String> a = new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertTrue(e.equals(a), desc + " expected " + e + ", actual " + a);
    }
}
