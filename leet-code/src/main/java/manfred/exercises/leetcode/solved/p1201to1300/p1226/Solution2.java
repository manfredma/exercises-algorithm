package manfred.exercises.leetcode.solved.p1201to1300.p1226;

import java.util.concurrent.Semaphore;

class DiningPhilosophers2 implements DiningPhilosophersApi {
    private static final int PHILOSOPHER_COUNT = 5;
    private final Semaphore room = new Semaphore(PHILOSOPHER_COUNT - 1, true);
    private final Semaphore[] forks = new Semaphore[PHILOSOPHER_COUNT];

    public DiningPhilosophers2() {
        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
            forks[i] = new Semaphore(1, true);
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % PHILOSOPHER_COUNT;

        room.acquire();
        try {
            forks[leftFork].acquire();
            try {
                pickLeftFork.run();
                forks[rightFork].acquire();
                try {
                    pickRightFork.run();
                    eat.run();
                } finally {
                    putRightFork.run();
                    forks[rightFork].release();
                }
            } finally {
                putLeftFork.run();
                forks[leftFork].release();
            }
        } finally {
            room.release();
        }
    }
}

interface DiningPhilosophersApi {
    void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException;
}
