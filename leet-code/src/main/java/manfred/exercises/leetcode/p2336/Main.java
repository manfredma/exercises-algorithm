package manfred.exercises.leetcode.p2336;

/*
现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...]。
实现 SmallestInfiniteSet：popSmallest() 移除并返回最小整数；addBack(num) 在 num 不存在时将其加入集合。

示例操作：
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
addBack(2)，popSmallest()，popSmallest()，popSmallest()，addBack(1)，popSmallest()，popSmallest()，popSmallest()
输出依次为：null，1，2，3，null，1，4，5。

提示：1 <= num <= 1000；最多调用 popSmallest 和 addBack 共计 1000 次。
*/
/** LeetCode 第 2336 题的测试入口。 */
public class Main {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        assertEquals(1, smallestInfiniteSet.popSmallest());
        assertEquals(2, smallestInfiniteSet.popSmallest());
        assertEquals(3, smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        assertEquals(1, smallestInfiniteSet.popSmallest());
        assertEquals(4, smallestInfiniteSet.popSmallest());
        assertEquals(5, smallestInfiniteSet.popSmallest());
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new AssertionError("expected: " + expected + ", actual: " + actual);
    }
}
