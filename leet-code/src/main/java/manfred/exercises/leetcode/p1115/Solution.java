package manfred.exercises.leetcode.p1115;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;

    private AtomicBoolean press = new AtomicBoolean(true);

    private ReentrantLock lock = new ReentrantLock();
    private Condition notify = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (press.get()) {
                    printFoo.run();
                    notify.signal();
                    press.set(false);
                } else {
                    notify.await();
                    i--;
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                if (!press.get()) {
                    printBar.run();
                    notify.signal();
                    press.set(true);
                } else {
                    notify.await();
                    i--;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
