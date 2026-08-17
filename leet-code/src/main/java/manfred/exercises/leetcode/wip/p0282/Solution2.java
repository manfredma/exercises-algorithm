package manfred.exercises.leetcode.wip.p0282;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    private final List<String> expressions = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        expressions.clear();
        search(num, target, 0, 0, 0, new StringBuilder());
        return expressions;
    }

    private void search(String num, int target, int index, long total, long previous, StringBuilder expression) {
        if (index == num.length()) {
            if (total == target) {
                expressions.add(expression.toString());
            }
            return;
        }

        long current = 0;
        int expressionLength = expression.length();
        for (int end = index; end < num.length(); end++) {
            if (end > index && num.charAt(index) == '0') {
                break;
            }

            current = current * 10 + num.charAt(end) - '0';
            if (index == 0) {
                expression.append(num, index, end + 1);
                search(num, target, end + 1, current, current, expression);
                expression.setLength(expressionLength);
                continue;
            }

            expression.append('+').append(num, index, end + 1);
            search(num, target, end + 1, total + current, current, expression);
            expression.setLength(expressionLength);

            expression.append('-').append(num, index, end + 1);
            search(num, target, end + 1, total - current, -current, expression);
            expression.setLength(expressionLength);

            expression.append('*').append(num, index, end + 1);
            search(num, target, end + 1,
                    total - previous + previous * current, previous * current, expression);
            expression.setLength(expressionLength);
        }
    }
}
