package exe01._09.string.rotation.lcci;

/**
 * CTCI 面试题 01.09「字符串轮转」的测试入口。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(solution.isFlipedString("aa", "aba"));
    }
}
