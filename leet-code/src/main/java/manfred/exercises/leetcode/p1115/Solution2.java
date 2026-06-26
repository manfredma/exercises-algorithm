package manfred.exercises.leetcode.p1115;

import java.util.concurrent.Semaphore;

/**
 * 解法二：双信号量。
 *
 * <p>fooSem 初始许可为 1（foo 先行），barSem 初始许可为 0（bar 先等）。
 * <pre>
 *   foo: acquire(fooSem) → print → release(barSem)
 *   bar: acquire(barSem) → print → release(fooSem)
 * </pre>
 * 两个信号量交替释放，天然保证 "foo → bar → foo → ..." 的顺序，
 * 无需显式锁、状态变量或 i-- 技巧。
 */
class FooBar2 {
    private final int n;
    private final Semaphore fooSem = new Semaphore(1); // foo 先行
    private final Semaphore barSem = new Semaphore(0); // bar 等待

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();
            printFoo.run(); // 输出 "foo"
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();
            printBar.run(); // 输出 "bar"
            fooSem.release();
        }
    }
}
