package manfred.exercises.ctci.c04;

/**
 * CTCI 面试题 01.04「回文排列」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPermutePalindrome("tactcoa"));
        System.out.println(solution.canPermutePalindrome("abd"));
        System.out.println(solution.canPermutePalindrome("aaa"));
    }
}
