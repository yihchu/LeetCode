package In.House.MultiThread.Q1116;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private boolean flag;
    private volatile int count;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.flag = true;
        this.count = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < this.n; ++i) {
            synchronized (this) {
                while (!this.flag) {
                    this.wait();
                }
                printNumber.accept(0);
                this.flag = !this.flag;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        if (this.n == 1) {
            return;
        }
        while (true) {
            synchronized (this) {
                while (this.flag || this.count % 2 == 1) {
                    this.wait();
                }
                printNumber.accept(this.count ++);
                this.flag = !this.flag;
                this.notifyAll();
                if (count >= n) {
                    break;
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (this.flag || this.count % 2 == 0) {
                    this.wait();
                }
                if (this.count > this.n) {
                    this.notifyAll();
                    break;
                }
                printNumber.accept(this.count ++);
                this.flag = !this.flag;
                this.notifyAll();
                if (count >= n) {
                    break;
                }
            }
        }
    }

    private static void test(int n) {
        IntConsumer consumer = (x) -> System.out.print(x);
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeo.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                zeo.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                zeo.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }

    public static void main(String[] args) {
        test(2);
    }

}
