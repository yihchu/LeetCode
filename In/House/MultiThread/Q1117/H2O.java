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




/**
Ques: H2O生成
Link: https://leetcode-cn.com/problems/building-h2o/

现在有两种线程，氧oxygen和氢hydrogen，你的目标是组织这两种线程来产生水分子。
存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
氢和氧线程会被分别给予releaseHydrogen和releaseOxygen方法来允许它们突破屏障。
这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。

换句话说:
如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
书写满足这些限制条件的氢、氧线程同步代码。

示例1:
输入: "HOH"
输出: "HHO"
解释: "HOH"和"OHH"依然都是有效解。

示例2:
输入: "OOHHHH"
输出: "HHOHHO"
解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH"和"OHHOHH"依然都是有效解。

提示：
输入字符串的总长将会是3n, 1 ≤ n ≤ 50；
输入字符串中的“H”总数将会是2n。
输入字符串中的“O”总数将会是n。
*/
