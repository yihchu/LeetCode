package Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 5; ++i) {
            new Worker(i, latch).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("!!!!!!!!!!!!!!!");
    }

     static class Worker extends Thread {

        private int id;
        private CountDownLatch latch;

        Worker(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(id * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(">>>>> Worker " + id + " Done.");
            latch.countDown();
        }
    }
}
