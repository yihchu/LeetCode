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

/**
Ques: 哲学家进餐
Link: https://leetcode-cn.com/problems/the-dining-philosophers

5个沉默寡言的哲学家围坐在圆桌前，每人面前一盘意面。叉子放在哲学家之间的桌面上。（5个哲学家，5根叉子）
所有的哲学家都只会在思考和进餐两种行为间交替。哲学家只有同时拿到左边和右边的叉子才能吃到面，而同一根叉子在同一时间只能被一个哲学家使用。每个哲学家吃完面后都需要把叉子放回桌面以供其他哲学家吃面。只要条件允许，哲学家可以拿起左边或者右边的叉子，但在没有同时拿到左右叉子时不能进食。
假设面的数量没有限制，哲学家也能随便吃，不需要考虑吃不吃得下。
设计一个进餐规则（并行算法）使得每个哲学家都不会挨饿；也就是说，在没有人知道别人什么时候想吃东西或思考的情况下，每个哲学家都可以在吃饭和思考之间一直交替下去。

如图1.png
问题描述和图片来自维基百科wikipedia.org

哲学家从0到4按顺时针编号。请实现函数void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)：
philosopher哲学家的编号。
pickLeftFork和pickRightFork表示拿起左边或右边的叉子。
eat表示吃面。
putLeftFork和putRightFork表示放下左边或右边的叉子。
由于哲学家不是在吃面就是在想着啥时候吃面，所以思考这个方法没有对应的回调。
给你5个线程，每个都代表一个哲学家，请你使用类的同一个对象来模拟这个过程。在最后一次调用结束之前，可能会为同一个哲学家多次调用该函数。

示例：
输入：n = 1
输出：[[4, 2, 1], [4, 1, 1], [0, 1, 1], [2, 2, 1], [2, 1, 1], [2, 0, 3], [2, 1, 2], [2, 2, 2], [4, 0, 3], [4, 1, 2], [0, 2, 1], [4, 2, 2], [3, 2, 1], [3, 1, 1], [0, 0, 3], [0, 1, 2], [0, 2, 2], [1, 2, 1], [1, 1, 1], [3, 0, 3], [3, 1, 2], [3, 2, 2], [1, 0, 3], [1, 1, 2], [1, 2, 2]]
解释:
n表示每个哲学家需要进餐的次数。
输出数组描述了叉子的控制和进餐的调用，它的格式如下：
output[i] = [a, b, c] (3个整数)
- a 哲学家编号。
- b 指定叉子：{1 : 左边, 2 : 右边}.
- c 指定行为：{1 : 拿起, 2 : 放下, 3 : 吃面}。
如[4, 2, 1]表示4号哲学家拿起了右边的叉子。

提示：
1 <= n <= 60
*/