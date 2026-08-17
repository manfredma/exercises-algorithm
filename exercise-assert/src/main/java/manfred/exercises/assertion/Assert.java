package manfred.exercises.assertion;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * 供练习题 {@code main} 方法使用的轻量断言工具，不依赖测试框架。
 */
public final class Assert {

    private static final double DEFAULT_DELTA = 1e-5;

    private Assert() {
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!deepEquals(expected, actual)) {
            fail(expected, actual);
        }
    }

    public static void assertEquals(double expected, double actual) {
        assertEquals(expected, actual, DEFAULT_DELTA);
    }

    public static void assertEquals(double expected, double actual, double delta) {
        if (Double.isNaN(expected) != Double.isNaN(actual)
                || (!Double.isNaN(expected) && Math.abs(expected - actual) > delta)) {
            fail(expected, actual);
        }
    }

    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            fail(expected, actual);
        }
    }

    public static void assertArrayEquals(Object expected, Object actual) {
        assertEquals(expected, actual);
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "expected condition to be true");
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertFalse(boolean condition) {
        assertFalse(condition, "expected condition to be false");
    }

    public static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError(message);
        }
    }

    public static void assertNull(Object actual) {
        if (actual != null) {
            throw new AssertionError("expected: null, actual: " + display(actual));
        }
    }

    public static void assertNotNull(Object actual) {
        if (actual == null) {
            throw new AssertionError("expected a non-null value");
        }
    }

    public static void assertSame(Object expected, Object actual) {
        if (expected != actual) {
            fail(expected, actual);
        }
    }

    public static void assertInRange(int actual, int minimum, int maximum) {
        if (actual < minimum || actual > maximum) {
            throw new AssertionError("expected range: [" + minimum + ", " + maximum
                    + "], actual: " + actual);
        }
    }

    public static void fail() {
        throw new AssertionError();
    }

    public static void fail(String message) {
        throw new AssertionError(message);
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

    private static void fail(Object expected, Object actual) {
        throw new AssertionError("expected: " + display(expected) + ", actual: " + display(actual));
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
