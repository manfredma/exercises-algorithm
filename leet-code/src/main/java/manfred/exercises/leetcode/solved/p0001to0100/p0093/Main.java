package manfred.exercises.leetcode.solved.p0001to0100.p0093;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/restore-ip-addresses/ */
public class Main {
    public static void main(String[] args) {
        // 旧解法 Solution / Solution2：保留验证，确保不被破坏（应通过）
        Solution s = new Solution();
        assertIpEquals(Arrays.asList("0.0.0.0"), s.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("1.1.1.1"), s.restoreIpAddresses("1111"), "1111");
        assertIpEquals(Arrays.asList("255.255.255.255"), s.restoreIpAddresses("255255255255"), "255255255255");
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s.restoreIpAddresses("25525511135"), "25525511135");
        // 边界：多解 / 全段超界 / 长度非法
        assertIpEquals(Arrays.asList("0.10.0.10", "0.100.1.0"), s.restoreIpAddresses("010010"), "010010");
        assertIpEquals(Collections.emptyList(), s.restoreIpAddresses("999999999999"), "999999999999");
        assertIpEquals(Collections.emptyList(), s.restoreIpAddresses("00000"), "00000(5位)");
        assertIpEquals(Collections.emptyList(), s.restoreIpAddresses("123"), "123(<4位)");

        Solution2 s2 = new Solution2();
        assertIpEquals(Arrays.asList("1.1.1.1"), s2.restoreIpAddresses("1111"), "1111");
        assertIpEquals(Arrays.asList("0.0.0.0"), s2.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("255.255.255.255"), s2.restoreIpAddresses("255255255255"), "255255255255");
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s2.restoreIpAddresses("25525511135"), "25525511135");
        assertIpEquals(Arrays.asList("0.10.0.10", "0.100.1.0"), s2.restoreIpAddresses("010010"), "010010");
        assertIpEquals(Collections.emptyList(), s2.restoreIpAddresses("999999999999"), "999999999999");
        assertIpEquals(Collections.emptyList(), s2.restoreIpAddresses("00000"), "00000(5位)");
        assertIpEquals(Collections.emptyList(), s2.restoreIpAddresses("123"), "123(<4位)");

        // 新解法 Solution3：再刷解法验证（已实现，BFS 层序，含多解/全超界/长度非法边界）
        Solution3 s3 = new Solution3();
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s3.restoreIpAddresses("25525511135"), "25525511135");
        assertIpEquals(Arrays.asList("0.0.0.0"), s3.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), s3.restoreIpAddresses("101023"), "101023");
        assertIpEquals(Arrays.asList("0.10.0.10", "0.100.1.0"), s3.restoreIpAddresses("010010"), "010010");
        assertIpEquals(Collections.emptyList(), s3.restoreIpAddresses("999999999999"), "999999999999");
        assertIpEquals(Collections.emptyList(), s3.restoreIpAddresses("00000"), "00000(5位)");
        assertIpEquals(Collections.emptyList(), s3.restoreIpAddresses("123"), "123(<4位)");

        // 新解法 Solution4：标准回溯验证（已实现，递归枚举每段 1-3 位 + 剪枝）
        Solution4 s4 = new Solution4();
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s4.restoreIpAddresses("25525511135"), "25525511135");
        assertIpEquals(Arrays.asList("0.0.0.0"), s4.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), s4.restoreIpAddresses("101023"), "101023");
        assertIpEquals(Arrays.asList("0.10.0.10", "0.100.1.0"), s4.restoreIpAddresses("010010"), "010010");
        assertIpEquals(Collections.emptyList(), s4.restoreIpAddresses("999999999999"), "999999999999");
        assertIpEquals(Collections.emptyList(), s4.restoreIpAddresses("00000"), "00000(5位)");
        assertIpEquals(Collections.emptyList(), s4.restoreIpAddresses("123"), "123(<4位)");
        System.out.println("leet#0093 passed");
    }

    private static void assertIpEquals(List<String> expected, List<String> actual, String desc) {
        assertNotNull(actual); // 骨架 return null 时 RED
        List<String> e = new ArrayList<>(expected);
        List<String> a = new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertTrue(e.equals(a), desc + " expected " + e + ", actual " + a);
    }
}
