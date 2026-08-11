package manfred.exercises.leetcode.solved.p1101to1200.p1195;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

class FizzBuzz2 implements FizzBuzzApi {
    private final int n;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition changed = lock.newCondition();
    private int cur = 1;

    public FizzBuzz2(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        runWhen(value -> value % 3 == 0 && value % 5 != 0, ignored -> printFizz.run());
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        runWhen(value -> value % 3 != 0 && value % 5 == 0, ignored -> printBuzz.run());
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        runWhen(value -> value % 15 == 0, ignored -> printFizzBuzz.run());
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        runWhen(value -> value % 3 != 0 && value % 5 != 0, printNumber);
    }

    private void runWhen(IntPredicate belongsToCurrentThread, IntConsumer printer) throws InterruptedException {
        lock.lock();
        try {
            while (cur <= n) {
                while (cur <= n && !belongsToCurrentThread.test(cur)) {
                    changed.await();
                }
                if (cur > n) {
                    break;
                }
                printer.accept(cur);
                cur++;
                changed.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
