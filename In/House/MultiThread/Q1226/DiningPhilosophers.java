package In.House.MultiThread.Q1226;

import java.util.Arrays;

public class DiningPhilosophers {

/** 最简单的解法，一次就一个哲学家进食，也能通过，就是不太好
//    public DiningPhilosophers() {
    public LT1226() {
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized (this) {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }
*/

/** 看来是5个锁比较笨重，花费的时间比上面那种粗暴解法还多，直接超时了
    private ReentrantLock[] locks = new ReentrantLock[5];

//    public DiningPhilosophers() {
    public LT1226() {
        for (int i = 0; i < 5; ++i) {
            locks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher + 4) % 5, right = philosopher;
        while (!this.locks[left].tryLock() || !this.locks[right].tryLock()) {
            if (this.locks[left].isHeldByCurrentThread()) {
                this.locks[left].unlock();
            }
            if (this.locks[right].isHeldByCurrentThread()){
                this.locks[right].unlock();
            }
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        this.locks[left].unlock();
        this.locks[right].unlock();
    }
*/

    private Integer[] forks = new Integer[5];

    public DiningPhilosophers() {
        Arrays.fill(forks, -1);
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher + 4) % 5, right = philosopher;
        synchronized (this) {
            while (this.forks[left] != -1 || this.forks[right] != -1) {
                this.wait();
            }
            this.forks[left] = philosopher;
            this.forks[right] = philosopher;
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        synchronized (this) {
            this.forks[left] = -1;
            this.forks[right] = -1;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        final int number = 5;

        DiningPhilosophers dphs = new DiningPhilosophers();
        Thread[] philosophers = new Thread[number];

        for (int i = 0; i < number; ++i) {
            int seq = i;
            philosophers[i] = new Thread(() -> {
                try {
                    dphs.wantsToEat(seq, () -> {
                        // pick left
                        System.out.println("[" + seq + ", 1, 1]");
                    }, () -> {
                        // pick right
                        System.out.println("[" + seq + ", 2, 1]");
                    }, () -> {
                        // eat
                        System.out.println("[" + seq + ", 0, 3]");
                    }, () -> {
                        // put left
                        System.out.println("[" + seq + ", 1, 2]");
                    }, () -> {
                        // put right
                        System.out.println("[" + seq + ", 2, 2]");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "philosopher-" + i);
            philosophers[i].start();
        }


        long startTime = System.currentTimeMillis();
        for (int i = 0; i < number; ++i) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(">>>>> cost " + (System.currentTimeMillis() - startTime));

    }
}