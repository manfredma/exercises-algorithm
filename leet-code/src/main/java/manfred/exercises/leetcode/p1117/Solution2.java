package manfred.exercises.leetcode.p1117;

import java.util.concurrent.Semaphore;

/** 两个氢线程完成后放行一个氧线程的信号量方案。 */
class H2O2 implements WaterMoleculeBuilder {
    private final Semaphore hydrogenSema = new Semaphore(2);
    private final Semaphore oxygenSema = new Semaphore(0);

    @Override
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSema.acquire();
        releaseHydrogen.run();
        oxygenSema.release();
    }

    @Override
    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSema.acquire(2);
        releaseOxygen.run();
        hydrogenSema.release(2);
    }
}
