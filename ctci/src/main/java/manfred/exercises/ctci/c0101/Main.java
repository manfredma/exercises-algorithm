package manfred.exercises.ctci.c0101;

/**
 * CTCI 面试题 01.01「判断字符是否唯一」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUnique("leetcode"));
        System.out.println(solution.isUnique("abc"));
    }
}
