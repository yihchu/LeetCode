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