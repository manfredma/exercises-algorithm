package manfred.exercises.ctci.c0103;

import static manfred.exercises.assertion.Assert.*;

/**
 * <a href="https://leetcode.cn/problems/string-to-url-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview">leetcode 题目</a>
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 题面示例1
        assertEquals("Mr%20John%20Smith", solution.replaceSpaces("Mr John Smith    ", 13));
        // 题面示例2
        assertEquals("%20%20%20%20%20", solution.replaceSpaces("               ", 5));

        SolutionV2 solutionV2 = new SolutionV2();
        assertEquals("Mr%20John%20Smith", solutionV2.replaceSpaces("Mr John Smith    ", 13));
        assertEquals("%20%20%20%20%20", solutionV2.replaceSpaces("               ", 5));
        // 手算：前 27 字符含 5 个空格，替换为 %20
        assertEquals("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf",
                solutionV2.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
        assertEquals("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf",
                solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
        System.out.println("passed");
    }
}
