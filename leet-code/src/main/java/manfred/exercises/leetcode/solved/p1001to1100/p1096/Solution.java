package manfred.exercises.leetcode.solved.p1001to1100.p1096;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode 第 1096 题「花括号展开 II」：递归下降解析表达式。
 *
 * <p>每层表达式以逗号划分为多个分支：{@code result} 收集已经结束的分支并集，
 * {@code ongoing} 保存当前分支的连续拼接结果。遇到子表达式时，对 {@code ongoing}
 * 和子表达式结果做笛卡尔积；集合同时负责去重。最外层补一个 {@code }} 作为哨兵，
 * 使根表达式与嵌套表达式共用同一套收敛逻辑。</p>
 *
 * <p>设最终不同字符串数为 {@code k}、单个字符串最大长度为 {@code m}，集合构造的空间
 * 为 {@code O(k * m)}；最终排序时间为 {@code O(k log k * m)}，解析与笛卡尔积的开销
 * 与中间、最终产生的字符串总长度成正比。</p>
 */
class Solution {
    public List<String> braceExpansionII(String expression) {
        // 逗号表示集合并集，直接拼接表示两个集合的笛卡尔积，按从左至右的顺序计算。
        // 因此整体思路和计算表达式的求值类似。
        List<String> result = new ArrayList<>(parseOneExpression(expression + "}", new int[]{0}));
        Collections.sort(result);
        return result;
    }

    private Set<String> parseOneExpression(String expression, int[] cur) {
        Set<String> result = new HashSet<>();
        Set<String> ongoing = new HashSet<>();
        // 必须放置一个单位元
        ongoing.add("");
        while (cur[0] < expression.length()) {
            if (expression.charAt(cur[0]) == '{') {
                cur[0]++;
                Set<String> subs = parseOneExpression(expression, cur);
                // 笛卡尔积！
                ongoing = product(ongoing, subs);

            } else if (expression.charAt(cur[0]) == '}') {
                // 当前表达式结束计算结束，将 ongoing 中的值收敛到 result 中
                cur[0]++;
                result.addAll(ongoing);
                break;
            } else if (expression.charAt(cur[0]) == ',') {
                // 这个“,”与当前的字符相符，那么预示ongoing 结束
                cur[0]++;
                result.addAll(ongoing);
                ongoing = new HashSet<>();
                ongoing.add("");
            } else {
                ongoing = ongoing.stream().map(a -> a + expression.charAt(cur[0])).collect(Collectors.toSet());
                cur[0]++;
            }
        }
        return result;
    }

    private Set<String> product(Set<String> a, Set<String> b) {
        Set<String> r = new HashSet<>();
        for (String aString : a) {
            for (String bString : b) {
                r.add(aString + bString);
            }
        }
        return r;
    }
}
