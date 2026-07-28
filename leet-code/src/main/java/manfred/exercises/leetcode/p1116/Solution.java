package manfred.exercises.leetcode.p1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 方案一：用 current 判断下一次应打印的数字。
 *
 * <p>此实现的收尾唤醒依赖 zero 线程已阻塞在下一次 zeroSem.acquire()。如果 zero 在线程
 * 切换后先看到 current > max 并退出，另一个奇偶线程可能仍阻塞在 acquire()，因此该方案
 * 存在与调度相关的退出竞态。方案二见 {@link ZeroEvenOdd2}。</p>
 */
class ZeroEvenOdd {
    private volatile int current = 1;

    private final Semaphore zeroSem = new Semaphore(1); // 先输出 0

    private final Semaphore oddSem = new Semaphore(0);

    private final Semaphore evenSem = new Semaphore(0);

    private final int max;
    public ZeroEvenOdd(int n) {
        this.max = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (current <= max) {
            zeroSem.acquire();
            // 只能打印 N 次，但是需要处理最后一次唤醒阻塞中的线程的作用！
            if (current <= max) {
                printNumber.accept(0);
            }
            if (current % 2 == 1) {
                oddSem.release();
            } else {
                evenSem.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (current <= max) {
            evenSem.acquire();
            if (current > max) {
                return;
            }
            int printNum = current;
            printNumber.accept(printNum);
            current++;
            zeroSem.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (current <= max) {
            oddSem.acquire();
            if (current > max) {
                return;
            }
            int printNum = current;
            printNumber.accept(printNum);
            current++;
            zeroSem.release();
        }
    }
}
