package Test;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycleBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < 8; ++i) {
            new Worker(i, barrier).start();
        }
    }

    static class Worker extends Thread {

        private int id;
        private CyclicBarrier barrier;

        Worker(int id, CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(id * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.println(">>>>> Worker " + id + " Done.");
        }
    }

}
