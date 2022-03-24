<h1>按序打印</h1>

我们提供了一个类：</br>
```java
public class Foo {
    public void first() { print("first"); }
    public void second() { print("second"); }
    public void third() { print("third"); }
}
```

三个不同的线程A、B、C将会共用一个Foo实例。</br>

一个将会调用first()方法</br>
一个将会调用second()方法</br>
还有一个将会调用third()方法</br>
请设计修改程序，以确保second()方法在first()方法之后被执行，third()方法在second()方法之后被执行。</br>

示例1:</br>
输入: [1, 2, 3]</br>
输出: "firstsecondthird"</br>
解释:</br>
有三个线程会被异步启动。</br>
输入[1, 2, 3]表示线程A将会调用first()方法，线程B将会调用second()方法，线程C将会调用third()方法。</br>
正确的输出是"firstsecondthird"。</br>

示例2:</br>
输入: [1, 3, 2]</br>
输出: "firstsecondthird"</br>
解释:</br>
输入[1, 3, 2]表示线程A将会调用first()方法，线程B将会调用third()方法，线程C将会调用second()方法。</br>
正确的输出是"firstsecondthird"。</br>

提示：</br>
尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。</br>
你看到的输入格式主要是为了确保测试的全面性。</br>

[Link](https://leetcode-cn.com/problems/print-in-order/)