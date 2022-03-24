<h1>打印零与奇偶数</h1>

假设有这么一个类：
```java
class ZeroEvenOdd {
    public ZeroEvenOdd(int n) { ... }     // 构造函数
    public void zero(printNumber) { ... }  // 仅打印出0
    public void even(printNumber) { ... }  // 仅打印出偶数
    public void odd(printNumber) { ... }   // 仅打印出奇数
}
```

相同的一个ZeroEvenOdd类实例将会传递给三个不同的线程：</br>
线程A将调用zero()，它只输出0。</br>
线程B将调用even()，它只输出偶数。</br>
线程C将调用odd()，它只输出奇数。</br>
每个线程都有一个printNumber方法来输出一个整数。请修改给出的代码以输出整数序列010203040506...，其中序列的长度必须为2n。</br>

示例1：</br>
输入：n = 2</br>
输出："0102"</br>
说明：三条线程异步执行，其中一个调用zero()，另一个线程调用even()，最后一个线程调用odd()。正确的输出为"0102"。</br>

示例2：</br>
输入：n = 5</br>
输出："0102030405"</br>

[Link](https://leetcode-cn.com/problems/print-zero-even-odd/)