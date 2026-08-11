package manfred.exercises.leetcode.solved.p0201to0300.p0282;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        return dfsAddOperators(num, target, 0, "", 0, 0);
    }

    private List<String> dfsAddOperators(String num, int target, int index, String expression, long total, long previours) {
        List<String> result = new ArrayList<>();
        // 如果是先导 0， 则只尝试拆除一个数字 0 即可
        for (int end = index; end < num.length() && (num.charAt(index) != '0' || end < index + 1); end++) {
            String part = num.substring(index, end + 1);
            long current = Long.parseLong(part);


            if (index == 0) {
                // 第一个数，不需要拼运算符
                result.addAll(dfsAddOperators(num, target, end + 1, part, current, current));
            } else {
                result.addAll(dfsAddOperators(num, target, end + 1, expression + "+" + part, total + current, current));
                result.addAll(dfsAddOperators(num, target, end + 1, expression + "-" + part, total - current, -current));
                result.addAll(dfsAddOperators(num, target, end + 1, expression + "*" + part, total - previours + current * previours, current * previours));
            }
        }
        if (index == num.length()) {
            if (total == target) {
                result.add(expression);
            }
        }
        return result;
    }
}
