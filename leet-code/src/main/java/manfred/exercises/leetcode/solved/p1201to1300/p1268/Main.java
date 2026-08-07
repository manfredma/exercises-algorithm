package manfred.exercises.leetcode.solved.p1201to1300.p1268;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * 每输入 searchWord 的一个字母，推荐 products 中前缀相同且字典序最靠前的最多三个产品。
 * 示例覆盖 mouse、havana、bags 以及完全无匹配的 tatiana 四种输入。
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
        assertSolutions(solution, solution2, Arrays.asList(list("mobile", "moneypot", "monitor"), list("mobile", "moneypot", "monitor"), list("mouse", "mousepad"), list("mouse", "mousepad"), list("mouse", "mousepad")), new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
        assertSolutions(solution, solution2, Arrays.asList(list("havana"), list("havana"), list("havana"), list("havana"), list("havana"), list("havana")), new String[]{"havana"}, "havana");
        assertSolutions(solution, solution2, Arrays.asList(list("baggage", "bags", "banner"), list("baggage", "bags", "banner"), list("baggage", "bags"), list("bags")), new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags");
        assertSolutions(solution, solution2, Arrays.asList(Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList(), Collections.<String>emptyList()), new String[]{"havana"}, "tatiana");
    }

    private static List<String> list(String... values) {
        return Arrays.asList(values);
    }

    private static void assertSolutions(Solution solution, Solution2 solution2, List<List<String>> expected,
                                        String[] products, String searchWord) {
        assertEquals(expected, solution.suggestedProducts(products.clone(), searchWord));
        assertEquals(expected, solution2.suggestedProducts(products.clone(), searchWord));
    }

    private static void assertEquals(List<List<String>> expected, List<List<String>> actual) {
        if (!expected.equals(actual)) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
