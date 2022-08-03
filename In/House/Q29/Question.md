<h1>两数相除</h1>\

给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。</br>
返回被除数dividend除以除数divisor得到的商。</br>
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2</br>

示例1:</br>
输入: dividend = 10, divisor = 3</br>
输出: 3</br>
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3</br>

示例2:</br>
输入: dividend = 7, divisor = -3</br>
输出: -2</br>
解释: 7/-3 = truncate(-2.33333..) = -2</br>

提示：
- 被除数和除数均为32位有符号整数。
- 除数不为0。
- 假设我们的环境只能存储32位有符号整数，其数值范围是[−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回2^31 − 1。

[Link](https://leetcode-cn.com/problems/divide-two-integers)