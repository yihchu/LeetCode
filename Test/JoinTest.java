package Test;

import java.util.Random;

public class JoinTest {

    public static void main(String[] args) {

        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; ++i) {
            threads[i] = new Thread(() -> {
                try {
                    System.out.println(">>>>> " + Thread.currentThread().getName() + " Run.");
                    Thread.sleep(1000 * (new Random().nextInt(5) + 1));
                    System.out.println(">>>>> " + Thread.currentThread().getName() + " Done.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "T" + i);
        }
        for (Thread thread: threads) {
            thread.start();
        }
        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("ALL DONE.");
    }
}
