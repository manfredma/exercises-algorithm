package manfred.exercises.leetcode.solved.p1101to1200.p1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/** 使用固定次数循环的信号量解法。 */
class ZeroEvenOdd2 {
    private final int n;
    private final Semaphore zeroSem = new Semaphore(1);
    private final Semaphore oddSem = new Semaphore(0);
    private final Semaphore evenSem = new Semaphore(0);

    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int number = 1; number <= n; number++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if ((number & 1) == 1) {
                oddSem.release();
            } else {
                evenSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int number = 2; number <= n; number += 2) {
            evenSem.acquire();
            printNumber.accept(number);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int number = 1; number <= n; number += 2) {
            oddSem.acquire();
            printNumber.accept(number);
            zeroSem.release();
        }
    }
}
