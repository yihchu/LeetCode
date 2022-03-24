<h1>交替打印FooBar</h1>

我们提供一个类：
```java
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
```

两个不同的线程将会共用一个FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。</br>
请设计修改程序，以确保"foobar"被输出n次。</br>

示例1:</br>
输入: n = 1</br>
输出: "foobar"</br>
解释: 这里有两个线程被异步启动。其中一个调用foo()方法, 另一个调用bar()方法，"foobar"将被输出一次。</br>

示例2:</br>
输入: n = 2</br>
输出: "foobarfoobar"</br>
解释: "foobar"将被输出两次。</br>

[Link](https://leetcode-cn.com/problems/print-foobar-alternately/)