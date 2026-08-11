package manfred.exercises.leetcode.solved.p1201to1300.p1226;

import java.util.concurrent.Semaphore;

class DiningPhilosophers implements DiningPhilosophersApi {

    // 叉子，其中 philosopher[i] 的左手对应其左手的叉子， i+1 代表右手的叉子（0 代表 哲学家4 的右手使用的叉子）
    private volatile Semaphore[] fork;

    private final int num = 5;

    public DiningPhilosophers() {
        fork = new Semaphore[num];
        fork[0] = new Semaphore(1);
        for (int i = 1; i < num; i++) {
            fork[i] = new Semaphore(0);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        fork[philosopher].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        fork[(philosopher + 1) % num].release(1);
    }
}
