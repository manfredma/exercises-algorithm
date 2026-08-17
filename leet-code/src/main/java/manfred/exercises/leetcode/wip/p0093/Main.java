package manfred.exercises.leetcode.wip.p0093;

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
        Solution2 s2 = new Solution2();
        assertIpEquals(Arrays.asList("1.1.1.1"), s2.restoreIpAddresses("1111"), "1111");
        assertIpEquals(Arrays.asList("0.0.0.0"), s2.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("255.255.255.255"), s2.restoreIpAddresses("255255255255"), "255255255255");
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s2.restoreIpAddresses("25525511135"), "25525511135");
        // 新解法 Solution3：新增验证，骨架占位下 RED，待实现后通过
        Solution3 s3 = new Solution3();
        assertIpEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), s3.restoreIpAddresses("25525511135"), "25525511135");
        assertIpEquals(Arrays.asList("0.0.0.0"), s3.restoreIpAddresses("0000"), "0000");
        assertIpEquals(Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"), s3.restoreIpAddresses("101023"), "101023");
        assertIpEquals(Collections.singletonList("0.0.0.0"), s3.restoreIpAddresses("0000"), "0000");
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
