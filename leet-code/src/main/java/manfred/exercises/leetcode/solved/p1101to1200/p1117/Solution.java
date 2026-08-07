package manfred.exercises.leetcode.solved.p1101to1200.p1117;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

interface WaterMoleculeBuilder {
    void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

    void oxygen(Runnable releaseOxygen) throws InterruptedException;
}

class H2O implements WaterMoleculeBuilder {

    private final Semaphore hydrogenSema = new Semaphore(2);
    private final Semaphore oxygenSema = new Semaphore(1);
    private final AtomicInteger batch = new AtomicInteger(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSema.acquire();
        releaseHydrogen.run();
        tryFinishBatch();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSema.acquire();
        releaseOxygen.run();
        tryFinishBatch();
    }

    private void tryFinishBatch() {
        if (batch.addAndGet(1) == 3) {
            batch.set(0);
            hydrogenSema.release(2);
            oxygenSema.release(1);
        }
    }
}
