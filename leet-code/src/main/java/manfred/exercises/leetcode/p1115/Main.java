package manfred.exercises.leetcode.p1115;

/*
给你一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}

两个不同的线程将会共用一个 FooBar 实例：
线程 A 将会调用 foo() 方法，而线程 B 将会调用 bar() 方法。
请设计修改程序，以确保 "foobar" 被输出 n 次。
提示：1 <= n <= 1000
*/
/**
 * LeetCode 第 1115 题的测试入口。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 示例 1: n = 1 → 期望输出 "foobar"
        test(1);
        System.out.println();
        // 示例 2: n = 2 → 期望输出 "foobarfoobar"
        test(2);
        System.out.println();
        // 示例 2: n = 3 → 期望输出 "foobarfoobarfoobar"
        test(3);
        System.out.println();
    }

    private static void test(int n) throws InterruptedException {
        FooBar fooBar = new FooBar(n);
        Thread threadA = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
