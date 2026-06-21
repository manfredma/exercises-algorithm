package manfred.exercises.leetcode.p0459;

class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // 构建 KMP 失配函数：fail[i] = s[0..i] 中最长的既是前缀又是后缀的子串长度
        int[] fail = new int[n];
        for (int i = 1; i < n; i++) {
            int j = fail[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = fail[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            fail[i] = j;
        }

        // 最小周期 = n - fail[n-1]
        // 若最小周期整除 n，且存在有效的前缀后缀（fail[n-1] > 0），则 s 由重复子串构成
        int period = n - fail[n - 1];
        return fail[n - 1] > 0 && n % period == 0;
    }
}
