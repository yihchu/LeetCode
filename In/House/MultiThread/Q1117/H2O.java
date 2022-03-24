package In.House.MultiThread.Q1117;

import java.util.concurrent.Semaphore;


// 通过了，但是感觉写的有点麻烦呢
//public class H2O {
//
//    private volatile int HCount;
//    private CyclicBarrier barrier;
//
//    public H2O() {
//        HCount = 0;
//        barrier = new CyclicBarrier(3);
//    }
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//        synchronized (this) {
//            while (this.HCount != 0 && this.HCount != 1) {
//                this.wait();
//            }
//            ++this.HCount;
//            this.notifyAll();
//        }
//        try {
//            this.barrier.await();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        synchronized (this) {
//            while (this.HCount != -2 && this.HCount != -1) {
//                this.wait();
//            }
//            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//            releaseHydrogen.run();
//            ++this.HCount;
//            this.notifyAll();
//        }
//
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//        synchronized (this) {
//            while (this.HCount != 2) {
//                this.wait();
//            }
//            try {
//                this.barrier.await();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//            // releaseOxygen.run() outputs "O". Do not change or remove this line.
//            releaseOxygen.run();
//            this.HCount = -2;
//            this.barrier.reset();
//            this.notifyAll();
//        }
//
//    }
//
//    private static void test(String str) {
//        H2O h2o = new H2O();
//        for (int i = 0; i < str.length(); ++i) {
//            char c = str.charAt(i);
//            new Thread(() -> {
//                try {
//                    if (c == 'O') {
//                        h2o.oxygen(() -> System.out.print("O"));
//                    } else {
//                        h2o.hydrogen(() -> System.out.print("H"));
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }
//
//    public static void main(String[] args) {
////        test("HOH");
//        for (int i = 0; i < 100; i ++) {
//            test("OHOOHOHHHHOHHOHHHH");
////            test("HHHHOO"); // OHOHHH
////            test("HHHHHHHHHHHHOOOOOO"); // OHH OHH HOH OOH HOH HHH
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//        }
//
//    }
//
//}


// 这个解法通过了11/11个测试用例，
// 也就是通过了所有测试用例
// 但是却告诉我超时
// 理解不能啊
//public class H20 {
//
//    private Semaphore OSemaphore;
//    private Semaphore HSemaphore;
//    private AtomicInteger count;
//
//    public H2O() {
//        OSemaphore = new Semaphore(1);
//        HSemaphore = new Semaphore(2);
//        count = new AtomicInteger(0);
//    }
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//
//        HSemaphore.acquire();
//        while (count.intValue() == 2) { }
//        count.incrementAndGet();
//        releaseHydrogen.run();
//        HSemaphore.release();
//
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//        OSemaphore.acquire();
//        while (count.intValue() < 2) { }
//        releaseOxygen.run();
//        count.set(0);
//        OSemaphore.release();
//    }
//
//    private static void test(String str) {
//        H2O h2o = new H2O();
//        for (int i = 0; i < str.length(); ++i) {
//            char c = str.charAt(i);
//            new Thread(() -> {
//                try {
//                    if (c == 'O') {
//                        h2o.oxygen(() -> System.out.print("O"));
//                    } else {
//                        h2o.hydrogen(() -> System.out.print("H"));
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//    }
//
//    public static void main(String[] args) {
////        test("HOH");
//        for (int i = 0; i < 100; i ++) {
//            test("OHOOHOHHHHOHHOHHHH");
////            test("HHHHOO"); // OHOHHH
////            test("HHHHHHHHHHHHOOOOOO"); // OHH OHH HOH OOH HOH HHH
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//        }
//
//    }
//
//}


public class  H2O {

    private Semaphore h, o;

    public H2O() {
        h = new Semaphore(2);
        o = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

    private static void test(String str) {
        H2O h2o = new H2O();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            new Thread(() -> {
                try {
                    if (c == 'O') {
                        h2o.oxygen(() -> System.out.print("O"));
                    } else {
                        h2o.hydrogen(() -> System.out.print("H"));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
//        test("HOH");
        for (int i = 0; i < 100; i ++) {
            test("OHOOHOHHHHOHHOHHHH");
//            test("HHHHOO"); // OHOHHH
//            test("HHHHHHHHHHHHOOOOOO"); // OHH OHH HOH OOH HOH HHH
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }

    }

}

