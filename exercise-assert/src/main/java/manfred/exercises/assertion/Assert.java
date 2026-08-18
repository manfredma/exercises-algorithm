package manfred.exercises.assertion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * 供练习题 {@code main} 方法使用的轻量断言工具，不依赖测试框架。
 * <p>
 * 失败信息设计：优先展示用例描述（desc），并自动附上调用位置（文件:行号），
 * 便于在大量用例中快速定位是哪个用例、哪行断言失败。
 * <ul>
 *   <li>带 desc 重载：{@code [desc] expected: X, actual: Y (at Main.java:44)}</li>
 *   <li>无 desc 旧调用：{@code expected: X, actual: Y (at Main.java:44)}</li>
 * </ul>
 * 调用位置通过 {@code Throwable.getStackTrace()} 取首个非本类的栈帧，开销仅在失败路径。
 */
public final class Assert {

    private static final double DEFAULT_DELTA = 1e-5;

    private Assert() {
    }

    public static void assertEquals(Object expected, Object actual) {
        assertEquals(expected, actual, null);
    }

    public static void assertEquals(Object expected, Object actual, String desc) {
        if (!deepEquals(expected, actual)) {
            fail(expected, actual, desc);
        }
    }

    public static void assertEquals(double expected, double actual) {
        assertEquals(expected, actual, DEFAULT_DELTA, null);
    }

    public static void assertEquals(double expected, double actual, String desc) {
        assertEquals(expected, actual, DEFAULT_DELTA, desc);
    }

    public static void assertEquals(double expected, double actual, double delta) {
        assertEquals(expected, actual, delta, null);
    }

    public static void assertEquals(double expected, double actual, double delta, String desc) {
        if (Double.isNaN(expected) != Double.isNaN(actual)
                || (!Double.isNaN(expected) && Math.abs(expected - actual) > delta)) {
            fail(expected, actual, desc);
        }
    }

    public static void assertEquals(long expected, long actual) {
        assertEquals(expected, actual, null);
    }

    public static void assertEquals(long expected, long actual, String desc) {
        if (expected != actual) {
            fail(expected, actual, desc);
        }
    }

    public static void assertArrayEquals(Object expected, Object actual) {
        assertEquals(expected, actual);
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, null);
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(format(message != null ? message : "expected condition to be true", null));
        }
    }

    public static void assertFalse(boolean condition) {
        assertFalse(condition, null);
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(format(message != null ? message : "expected condition to be false", null));
        }
    }

    public static void assertNull(Object actual) {
        assertNull(actual, null);
    }

    public static void assertNull(Object actual, String desc) {
        if (actual != null) {
            throw new AssertionError(format("expected: null, actual: " + display(actual), desc));
        }
    }

    public static void assertNotNull(Object actual) {
        assertNotNull(actual, null);
    }

    public static void assertNotNull(Object actual, String desc) {
        if (actual == null) {
            throw new AssertionError(format("expected a non-null value", desc));
        }
    }

    public static void assertSame(Object expected, Object actual) {
        assertSame(expected, actual, null);
    }

    public static void assertSame(Object expected, Object actual, String desc) {
        if (expected != actual) {
            fail(expected, actual, desc);
        }
    }

    public static void assertInRange(int actual, int minimum, int maximum) {
        assertInRange(actual, minimum, maximum, null);
    }

    public static void assertInRange(int actual, int minimum, int maximum, String desc) {
        if (actual < minimum || actual > maximum) {
            throw new AssertionError(format("expected range: [" + minimum + ", " + maximum
                    + "], actual: " + actual, desc));
        }
    }

    public static void fail() {
        throw new AssertionError();
    }

    public static void fail(String message) {
        throw new AssertionError(format(message, null));
    }

    private static boolean deepEquals(Object expected, Object actual) {
        if (expected == actual) {
            return true;
        }
        if (expected == null || actual == null) {
            return false;
        }
        if (expected.getClass().isArray() && actual.getClass().isArray()) {
            int length = Array.getLength(expected);
            if (length != Array.getLength(actual)) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (!deepEquals(Array.get(expected, i), Array.get(actual, i))) {
                    return false;
                }
            }
            return true;
        }
        return Objects.equals(expected, actual);
    }

    private static void fail(Object expected, Object actual, String desc) {
        throw new AssertionError(format("expected: " + display(expected) + ", actual: " + display(actual), desc));
    }

    /** 组装失败信息：[desc] message (at File:line)。desc 为 null 时省略前缀。 */
    private static String format(String message, String desc) {
        StringBuilder sb = new StringBuilder();
        if (desc != null && !desc.isEmpty()) {
            sb.append("[").append(desc).append("] ");
        }
        sb.append(message);
        String location = callerLocation();
        if (location != null) {
            sb.append(" (at ").append(location).append(")");
        }
        return sb.toString();
    }

    /** 取调用方栈帧（首个非 Assert 类），返回 文件名:行号；取不到返回 null。 */
    private static String callerLocation() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        for (StackTraceElement frame : stack) {
            if (!Assert.class.getName().equals(frame.getClassName())) {
                return frame.getFileName() + ":" + frame.getLineNumber();
            }
        }
        return null;
    }

    private static String display(Object value) {
        if (value == null || !value.getClass().isArray()) {
            return String.valueOf(value);
        }
        if (value instanceof Object[]) {
            return Arrays.deepToString((Object[]) value);
        }
        if (value instanceof int[]) {
            return Arrays.toString((int[]) value);
        }
        if (value instanceof long[]) {
            return Arrays.toString((long[]) value);
        }
        if (value instanceof double[]) {
            return Arrays.toString((double[]) value);
        }
        if (value instanceof float[]) {
            return Arrays.toString((float[]) value);
        }
        if (value instanceof boolean[]) {
            return Arrays.toString((boolean[]) value);
        }
        if (value instanceof byte[]) {
            return Arrays.toString((byte[]) value);
        }
        if (value instanceof short[]) {
            return Arrays.toString((short[]) value);
        }
        if (value instanceof char[]) {
            return Arrays.toString((char[]) value);
        }
        return String.valueOf(value);
    }
}
