package manfred.exercises.leetcode.p1114;

/*
给你一个类：

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}

三个不同的线程 A、B、C 将会共用一个 Foo 实例。
线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，
third() 方法在 second() 方法之后被执行。

提示：nums 是 [1, 2, 3] 的一组排列。
*/

/**
 * LeetCode 第 1114 题的测试入口。
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // 示例 1：nums = [1,2,3] → 期望输出 "firstsecondthird"
        Solution foo = new Solution();
        StringBuilder sb = new StringBuilder();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> sb.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> sb.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> sb.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 按 [1,2,3] 顺序启动
        t1.start(); t2.start(); t3.start();
        t1.join();  t2.join();  t3.join();
        System.out.println(sb.toString()); // 期望：firstsecondthird

        // 示例 2：nums = [1,3,2] — 先启动 t3，再启动 t2
        Solution foo2 = new Solution();
        StringBuilder sb2 = new StringBuilder();

        Thread a1 = new Thread(() -> {
            try {
                foo2.first(() -> sb2.append("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread a3 = new Thread(() -> {
            try {
                foo2.third(() -> sb2.append("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread a2 = new Thread(() -> {
            try {
                foo2.second(() -> sb2.append("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 按 [1,3,2] 顺序启动
        a1.start(); a3.start(); a2.start();
        a1.join();  a3.join();  a2.join();
        System.out.println(sb2.toString()); // 期望：firstsecondthird
    }
}
