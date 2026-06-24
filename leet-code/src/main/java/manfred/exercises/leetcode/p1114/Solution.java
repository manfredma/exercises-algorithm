package manfred.exercises.leetcode.p1114;

import java.util.concurrent.CountDownLatch;

class Solution {

    private final CountDownLatch firstFinished = new CountDownLatch(1);
    private final CountDownLatch secondFinished = new CountDownLatch(1);

    public Solution() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstFinished.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        firstFinished.await();
        printSecond.run();
        secondFinished.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondFinished.await();
        printThird.run();
    }
}
