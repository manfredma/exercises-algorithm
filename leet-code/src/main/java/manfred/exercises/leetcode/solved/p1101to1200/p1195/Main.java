package manfred.exercises.leetcode.solved.p1101to1200.p1195;

import static manfred.exercises.assertion.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** 题目链接：https://leetcode.cn/problems/fizz-buzz-multithreaded/ */

/*
编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：


如果这个数字可以被 3 整除，输出 "fizz"。


如果这个数字可以被 5 整除，输出 "buzz"。


如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。

例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。

假设有这么一个类：

class FizzBuzz {
  public FizzBuzz(int n) { ... }              // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}

请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：


线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。


线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。


线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。


线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。


提示：


本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。
*/
/** LeetCode 第 1195 题的测试入口。 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        assertAllImplementations(
                15,
                "1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz");
        assertAllImplementations(1, "1");
        assertAllImplementations(3, "1", "2", "fizz");
        assertAllImplementations(5, "1", "2", "fizz", "4", "buzz");
    }

    private static void assertAllImplementations(int n, String... expected) throws InterruptedException {
        assertOutput(new FizzBuzz(n), expected);
        assertOutput(new FizzBuzz2(n), expected);
        assertOutput(new FizzBuzz3(n), expected);
    }

    private static void assertOutput(FizzBuzzApi fizzBuzz, String... expected) throws InterruptedException {
        List<String> actual = Collections.synchronizedList(new ArrayList<String>());
        Thread fizz = new Thread(() -> runUnchecked(() -> fizzBuzz.fizz(() -> actual.add("fizz"))));
        Thread buzz = new Thread(() -> runUnchecked(() -> fizzBuzz.buzz(() -> actual.add("buzz"))));
        Thread fizzbuzz = new Thread(() -> runUnchecked(() -> fizzBuzz.fizzbuzz(() -> actual.add("fizzbuzz"))));
        Thread number = new Thread(() -> runUnchecked(() -> fizzBuzz.number(value -> actual.add(String.valueOf(value)))));
        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();
        fizz.join();
        buzz.join();
        fizzbuzz.join();
        number.join();
        assertArrayEquals(expected, actual.toArray(new String[0]));
    }

    private static void runUnchecked(InterruptibleAction action) {
        try {
            action.run();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(exception);
        }
    }

    private interface InterruptibleAction {
        void run() throws InterruptedException;
    }
}
