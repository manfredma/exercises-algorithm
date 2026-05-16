package exe01._05.one.away.lcci;

/**
 * CTCI 面试题 01.05「一次编辑」的测试入口。
 */
public class Main {

    public static void main(String[] args) {
        SolutionV2 solutionV2 = new SolutionV2();
        System.out.println(solutionV2.oneEditAway("pale", "ple"));
        System.out.println(solutionV2.oneEditAway("pales", "pales"));
        System.out.println(solutionV2.oneEditAway("pales", "pal"));
        System.out.println(solutionV2.oneEditAway("", "a"));

        Solution solution = new Solution();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "pales"));
        System.out.println(solution.oneEditAway("pales", "pal"));
        System.out.println(solution.oneEditAway("", "a"));
    }
}
