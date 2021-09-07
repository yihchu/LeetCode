import java.util.function.IntConsumer;

public class LT1116 {

    private int n;
    private boolean flag;
    private volatile int count;

//    public ZeroEvenOdd(int n) {
    public LT1116(int n) {
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
        LT1116 lt1116 = new LT1116(n);
        new Thread(() -> {
            try {
                lt1116.zero(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                lt1116.even(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                lt1116.odd(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }

    public static void main(String[] args) {
        test(2);
    }

}

/*

假设有这么一个类：

class ZeroEvenOdd {
    public ZeroEvenOdd(int n) { ... }     // 构造函数
    public void zero(printNumber) { ... }  // 仅打印出0
    public void even(printNumber) { ... }  // 仅打印出偶数
    public void odd(printNumber) { ... }   // 仅打印出奇数
}

相同的一个ZeroEvenOdd类实例将会传递给三个不同的线程：
线程A将调用zero()，它只输出0。
线程B将调用even()，它只输出偶数。
线程C将调用odd()，它只输出奇数。
每个线程都有一个printNumber方法来输出一个整数。请修改给出的代码以输出整数序列010203040506...，其中序列的长度必须为2n。

示例 1：
输入：n = 2
输出："0102"
说明：三条线程异步执行，其中一个调用zero()，另一个线程调用even()，最后一个线程调用odd()。正确的输出为"0102"。

示例 2：
输入：n = 5
输出："0102030405"

*/
