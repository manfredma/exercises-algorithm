package manfred.exercises.ctci.c02;

/**
 * CTCI 面试题 01.02「判定是否互为字符重排」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("aa", "ab"));
        System.out.println(solution.CheckPermutation("abc", "bca"));
        System.out.println(solution.CheckPermutation("aa", "aa"));
    }
}
