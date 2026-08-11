package manfred.exercises.leetcode.solved.p1101to1200.p1195;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz implements FizzBuzzApi {
    private final int n;

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition fizz = reentrantLock.newCondition();
    private final Condition buzz = reentrantLock.newCondition();
    private final Condition fizzBuzz = reentrantLock.newCondition();
    private final Condition printNum = reentrantLock.newCondition();
    private int cur = 1;

    public FizzBuzz(int n) {
        this.n = n;

    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur <= n) {
                if (cur % 3 == 0 && cur % 5 != 0) {
                    printFizz.run();
                    printNum.signal();
                }
                fizz.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur <= n) {
                if (cur % 3 != 0 && cur % 5 == 0) {
                    printBuzz.run();
                    printNum.signal();
                }
                buzz.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }


    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur <= n) {
                if (cur % 5 == 0 && cur % 3 == 0) {
                    printFizzBuzz.run();
                    printNum.signal();
                }
                fizzBuzz.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur <= n) {
                if (cur % 3 != 0 && cur % 5 != 0) {
                    printNumber.accept(cur);
                } else {
                    if (cur % 3 != 0 && cur % 5 == 0) {
                        buzz.signal();
                    } else if (cur % 3 == 0 && cur % 5 != 0) {
                        fizz.signal();
                    } else {
                        fizzBuzz.signal();
                    }
                    printNum.await();
                }
                cur++;
                if (cur > n) {
                    fizz.signal();
                    buzz.signal();
                    fizzBuzz.signal();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

interface FizzBuzzApi {
    void fizz(Runnable printFizz) throws InterruptedException;

    void buzz(Runnable printBuzz) throws InterruptedException;

    void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;

    void number(IntConsumer printNumber) throws InterruptedException;
}
