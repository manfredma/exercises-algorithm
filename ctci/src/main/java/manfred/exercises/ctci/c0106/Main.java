package manfred.exercises.ctci.c0106;

/**
 * CTCI 面试题 01.06「字符串压缩」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
        System.out.println(solution.compressString("abbccd"));
    }
}
