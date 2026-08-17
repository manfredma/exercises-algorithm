package manfred.exercises.leetcode.solved.p0001to0100.p0013;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 13 题「罗马数字转整数」：从左向右扫描，若当前值小于右侧值则减去，否则加上。
 * <p>
 * 罗马数字规则（题目保证输入合法，本解不校验）：
 * <ul>
 *   <li>通常小数在大数右边，直接累加（如 XII=12、XXVII=27）。</li>
 *   <li>「小在大前」表减法，但仅限六种组合：IV/IX、XL/XC、CD/CM；
 *       且每个大值左侧至多一位减法小值，故 8=VIII 而非 IIX，9=IX 而非 VIIII。</li>
 *   <li>V/L/D（5/50/500）不能作减法前缀，I/X/C（1/10/100）才能。</li>
 * </ul>
 * <p>
 * 算法依赖上述「至多一位前缀」约束：只比较当前位与右邻即可定加/减，因为合法减法对恒为
 * 「小大」紧邻二字符组，小值右邻即触发它减的大值。若放宽为允许多位前缀（如 IIX=8），
 * 第一位 I 右邻是等值 I 会被判加而非减，算法即失效。故正确性以输入合法为前提，非法输入未定义。
 * 复杂度：时间 O(n)，空间 O(1)（符号表可用 switch 进一步消除 HashMap）。
 */
class Solution {
    Map<Character, Integer> symbols = new HashMap<>();
    {
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);
    }
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() -1 || symbols.get(s.charAt(i)) >= symbols.get(s.charAt(i + 1)) ) {
                result += symbols.get(s.charAt(i));
            } else {
                result -= symbols.get(s.charAt(i));
            }
        }
        return result;
    }
}