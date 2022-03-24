package In.House.MultiThread.Q1195;

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