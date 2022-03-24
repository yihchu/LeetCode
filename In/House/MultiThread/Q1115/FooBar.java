package In.House.MultiThread.Q1115;

public class FooBar {

    private int n;
    private boolean flag;

    public FooBar(int n) {
        this.n = n;
        this.flag = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!this.flag) {
                    this.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                this.flag = !this.flag;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (this) {
                while (this.flag) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.flag = !this.flag;
                this.notifyAll();
            }

        }
    }

    private static void test(int n) {
        Runnable foo = () -> System.out.print("foo");
        Runnable bar = () -> System.out.print("bar");

        FooBar fb = new FooBar(n);
        new Thread(() -> {
            try {
                fb.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
//        test(1); // "foobar"
//        test(2); // "foobarfoobar"
        test(5);
    }

}