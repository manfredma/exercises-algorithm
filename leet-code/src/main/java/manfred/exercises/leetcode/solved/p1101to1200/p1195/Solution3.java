package manfred.exercises.leetcode.solved.p1101to1200.p1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz3 implements FizzBuzzApi {
    private final int n;
    private final Semaphore number = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz3(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < n / 3 - n / 15; i++) {
            fizz.acquire();
            printFizz.run();
            number.release();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i < n / 5 - n / 15; i++) {
            buzz.acquire();
            printBuzz.run();
            number.release();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i < n / 15; i++) {
            fizzbuzz.acquire();
            printFizzBuzz.run();
            number.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int value = 1; value <= n; value++) {
            number.acquire();
            if (value % 15 == 0) {
                fizzbuzz.release();
            } else if (value % 3 == 0) {
                fizz.release();
            } else if (value % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(value);
                number.release();
            }
        }
    }
}
