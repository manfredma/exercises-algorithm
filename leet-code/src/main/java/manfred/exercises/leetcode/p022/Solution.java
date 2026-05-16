package manfred.exercises.leetcode.p022;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 第 22 题「括号生成」：回溯法，记录已用左右括号数，合法时递归添加。
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Node root = new Node(n, n, "");
        generateSun(root, result);
        return result;
    }

    private void generateSun(Node p, List<String> result) {
        if (p.leftP < p.rightP) {
            p.rightN = new Node(p.leftP, p.rightP - 1, p.s + ")");
            generateSun(p.rightN, result);
        }
        if (p.leftP > 0) {
            p.leftN = new Node(p.leftP - 1, p.rightP, p.s + "(");
            generateSun(p.leftN, result);
        }

        if (null == p.leftN && null == p.rightN) {
            result.add(p.s);
        }
    }

    static class Node {
        private int leftP;
        private int rightP;

        private Node leftN;
        private Node rightN;

        private String s;

        Node(int leftP, int rightP, String s) {
            this.leftP = leftP;
            this.rightP = rightP;
            this.s = s;
        }
    }
}

