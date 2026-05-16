package manfred.exercises.algorithm.string.match;

/**
 * 字符串匹配算法的统一接口，BF、RK、BM、KMP 等算法均实现此接口，便于对比测试各算法性能。
 */
public interface StringMatcher {
    boolean match(String src, String pattern);
}
