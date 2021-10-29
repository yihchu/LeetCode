package In.House.Q1195;

import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private volatile int start;

    public FizzBuzz(int n) {
        this.start = 1;
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (this.start <= this.n) {
                while ((this.start % 3 != 0 || this.start % 5 == 0) && this.start <= this.n) {
                    this.wait();
                }
                if (this.start > this.n) {
                    this.notifyAll();
                    return;
                }
                printFizz.run();
                ++ this.start;
                this.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (this.start <= this.n) {
                while ((this.start % 5 != 0 || this.start % 3 == 0) && this.start <= this.n) {
                    this.wait();
                }
                if (this.start > this.n) {
                    this.notifyAll();
                    return;
                }
                printBuzz.run();
                ++ this.start;
                this.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (this.start <= this.n) {
                while ((this.start % 5 != 0 || this.start % 3 != 0) && this.start <= this.n) {
                    this.wait();
                }
                if (this.start > this.n) {
                    this.notifyAll();
                    return;
                }
                printFizzBuzz.run();
                ++ this.start;
                this.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (this.start <= this.n) {
                while ((this.start % 5 == 0 || this.start % 3 == 0) && this.start <= this.n) {
                    this.wait();
                }
                if (this.start > this.n) {
                    this.notifyAll();
                    return;
                }
                printNumber.accept(this.start);
                ++ this.start;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(100);

        Thread fizz = new Thread(() -> {
            try {
                fb.fizz(() -> System.out.print("fizz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread buzz = new Thread(() -> {
            try {
                fb.buzz(() -> System.out.print("buzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread fizzbuzz = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.print("fizzbuzz, "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread number = new Thread(() -> {
            try {
                fb.number((x) -> System.out.print(x + ", "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();

        try {
            fizz.join();
            buzz.join();
            fizzbuzz.join();
            number.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

/**
Link: https://leetcode-cn.com/problems/fizz-buzz-multithreaded

编写一个可以从1到n输出代表这个数字的字符串的程序，但是：

如果这个数字可以被3整除，输出"fizz"。
如果这个数字可以被5整除，输出"buzz"。
如果这个数字可以同时被3和5整除，输出"fizzbuzz"。
例如，当n = 15，输出：1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。

假设有这么一个类：
class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}
请你实现一个有四个线程的多线程版FizzBuzz，同一个FizzBuzz实例会被如下四个线程使用：

线程A将调用fizz()来判断是否能被3整除，如果可以，则输出fizz。
线程B将调用buzz()来判断是否能被5整除，如果可以，则输出buzz。
线程C将调用fizzbuzz()来判断是否同时能被3和5整除，如果可以，则输出fizzbuzz。
线程D将调用number()来实现输出既不能被3整除也不能被5整除的数字。

提示：
本题已经提供了打印字符串的相关方法，如printFizz()等，具体方法名请参考答题模板中的注释部分。

*/