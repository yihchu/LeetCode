public class LT1115 {

    private int n;
    private boolean flag;

//    public FooBar(int n) {
    public LT1115(int n) {
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

        LT1115 lt1115 = new LT1115(n);
        new Thread(() -> {
            try {
                lt1115.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                lt1115.bar(bar);
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

/*

我们提供一个类：

class FooBar {

    public void foo() {
        for (int i = 0; i < n; i++) {
            print("foo");
        }
    }

  public void bar() {
        for (int i = 0; i < n; i++) {
            print("bar");
        }
    }
}

两个不同的线程将会共用一个FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。
请设计修改程序，以确保 "foobar" 被输出 n 次。

示例 1:
输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用foo()方法, 另一个调用bar()方法，"foobar"将被输出一次。

示例 2:
输入: n = 2
输出: "foobarfoobar"
解释: "foobar"将被输出两次。

*/