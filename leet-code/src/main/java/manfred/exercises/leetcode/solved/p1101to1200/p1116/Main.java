package manfred.exercises.leetcode.solved.p1101to1200.p1116;

import static manfred.exercises.assertion.Assert.*;

/** 题目链接：https://leetcode.cn/problems/print-zero-even-odd/ */

/*
现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。
例如，调用 printNumber(7) 将会输出 7 到控制台。

给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd。
ZeroEvenOdd 的相同实例将会传递给三个不同线程：

线程 A：调用 zero()，只输出 0。
线程 B：调用 even()，只输出偶数。
线程 C：调用 odd()，只输出奇数。

修改给出的类，以输出序列 "010203040506..."，其中序列的长度必须为 2n。

实现 ZeroEvenOdd 类：
ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。
void zero(printNumber) 调用 printNumber 以输出一个 0。
void even(printNumber) 调用 printNumber 以输出偶数。
void odd(printNumber) 调用 printNumber 以输出奇数。

示例 1：
输入：n = 2
输出："0102"
解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用 odd()。
正确的输出为 "0102"。

示例 2：
输入：n = 5
输出："0102030405"

提示：
1 <= n <= 1000
*/
/** LeetCode 第 1116 题的测试入口。 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        assertOutput(2, "0102");
        assertOutput(5, "0102030405");
    }

    private static void assertOutput(int n, String expected) throws InterruptedException {
        ZeroEvenOdd2 zeroEvenOdd = new ZeroEvenOdd2(n);
        StringBuffer output = new StringBuffer();

        Thread zeroThread = new Thread(() -> run(() -> zeroEvenOdd.zero(output::append)));
        Thread evenThread = new Thread(() -> run(() -> zeroEvenOdd.even(output::append)));
        Thread oddThread = new Thread(() -> run(() -> zeroEvenOdd.odd(output::append)));
        zeroThread.start();
        evenThread.start();
        oddThread.start();
        zeroThread.join(1000);
        evenThread.join(1000);
        oddThread.join(1000);
        if (zeroThread.isAlive() || evenThread.isAlive() || oddThread.isAlive()) {
            fail("线程未在预期时间内结束");
        }

        assertEquals(expected, output.toString());
        System.out.println("通过：" + expected);
    }

    private static void run(InterruptibleTask task) {
        try {
            task.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private interface InterruptibleTask {
        void run() throws InterruptedException;
    }
}
