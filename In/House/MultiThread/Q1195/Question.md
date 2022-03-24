<h1>交替打印字符串</h1>

编写一个可以从1到n输出代表这个数字的字符串的程序，但是：</br>

如果这个数字可以被3整除，输出"fizz"。</br>
如果这个数字可以被5整除，输出"buzz"。</br>
如果这个数字可以同时被3和5整除，输出"fizzbuzz"。</br>
例如，当n = 15，输出：1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。

假设有这么一个类：
```java
class FizzBuzz {
    public FizzBuzz(int n) { ... }               // constructor
    public void fizz(printFizz) { ... }          // only output "fizz"
    public void buzz(printBuzz) { ... }          // only output "buzz"
    public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
    public void number(printNumber) { ... }      // only output the numbers
}
```
请你实现一个有四个线程的多线程版FizzBuzz，同一个FizzBuzz实例会被如下四个线程使用：</br>
线程A将调用fizz()来判断是否能被3整除，如果可以，则输出fizz。</br>
线程B将调用buzz()来判断是否能被5整除，如果可以，则输出buzz。</br>
线程C将调用fizzbuzz()来判断是否同时能被3和5整除，如果可以，则输出fizzbuzz。</br>
线程D将调用number()来实现输出既不能被3整除也不能被5整除的数字。</br>

提示：</br>
本题已经提供了打印字符串的相关方法，如printFizz()等，具体方法名请参考答题模板中的注释部分。</br>

[Link](https://leetcode-cn.com/problems/fizz-buzz-multithreaded)