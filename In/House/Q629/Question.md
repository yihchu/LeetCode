<h1>K个逆序对数组</h1>

给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。</br>
逆序对的定义如下：对于数组的第i个和第j个元素，如果满i<j且a[i]>a[j]，则其为一个逆序对；否则不是。</br>
由于答案可能很大，只需要返回答案(mod 10^9 + 7)的值。</br>

示例1:</br>
输入: n = 3, k = 0</br>
输出: 1</br>
解释:</br>
只有数组[1, 2, 3]包含了从1到3的整数并且正好拥有0个逆序对。</br>

示例2:</br>
输入: n = 3, k = 1</br>
输出: 2</br>
解释:</br>
数组[1, 3, 2]和[2, 1, 3]都有1个逆序对。</br>
说明:</br>
n的范围是[1, 1000]并且k的范围是[0, 1000]。</br>

[Link](https://leetcode-cn.com/problems/k-inverse-pairs-array/)