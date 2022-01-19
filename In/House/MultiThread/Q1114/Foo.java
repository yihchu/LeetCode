package In.House.MultiThread.Q1114;

public class Foo {

    private volatile int current;

    public Foo() {
        this.current = 0;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this) {
            while (this.current != 0) {
                this.wait();
            }
            printFirst.run();
            ++this.current;
            this.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (this) {
            while (this.current != 1) {
                this.wait();
            }
            printSecond.run();
            ++this.current;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (this) {
            while (this.current != 2) {
                this.wait();
            }
            printThird.run();
            ++this.current;
            this.notifyAll();
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");


        // test1
        new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
        new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();


//        // test2
//        new Thread(printFirst, "A").start();
//        new Thread(printThird, "B").start();
//        new Thread(printSecond, "C").start();
    }

}

/**
Ques: 按序打印
Link: https://leetcode-cn.com/problems/print-in-order/

我们提供了一个类：
public class Foo {
    public void first() { print("first"); }
    public void second() { print("second"); }
    public void third() { print("third"); }
}

三个不同的线程A、B、C将会共用一个Foo实例。

一个将会调用first()方法
一个将会调用second()方法
还有一个将会调用third()方法
请设计修改程序，以确保second()方法在first()方法之后被执行，third()方法在second()方法之后被执行。

示例1:
输入: [1, 2, 3]
输出: "firstsecondthird"
解释:
有三个线程会被异步启动。
输入[1, 2, 3]表示线程A将会调用first()方法，线程B将会调用second()方法，线程C将会调用third()方法。
正确的输出是 "firstsecondthird"。

示例2:
输入: [1, 3, 2]
输出: "firstsecondthird"
解释:
输入[1, 3, 2]表示线程A将会调用first()方法，线程B将会调用third()方法，线程C将会调用second()方法。
正确的输出是 "firstsecondthird"。

提示：
尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
你看到的输入格式主要是为了确保测试的全面性。


*/