package manfred.exercises.leetcode.p1422;

class Solution {
    public int maxScore(String s) {
        int result = 0;
        // 初始化基础拆分的分数
        int left = s.charAt(0) == '0' ? 1 : 0;
        int right = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        result = Math.max(left + right, result);
        // 尝试在中间任意节点拆分的分数，依次递推获取
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                right--;
            }
            result = Math.max(left + right, result);
        }
        return result;
    }
}
