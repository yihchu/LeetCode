<h1>超级丑数</h1>

超级丑数是一个正整数，并满足其所有质因数都出现在质数数组primes中。<br>
给你一个整数n和一个整数数组primes，返回第n个超级丑数。<br>
题目数据保证第n个超级丑数在32-bit带符号整数范围内。<br>

示例1：<br>
输入：n = 12, primes = [2, 7, 13, 19]<br>
输出：32<br>
解释：给定长度为4的质数数组primes = [2, 7, 13, 19]，前12个超级丑数序列为：[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]。<br>

示例2：<br>
输入：n = 1, primes = [2, 3, 5]<br>
输出：1<br>
解释：1不含质因数，因此它的所有质因数都在质数数组primes = [2, 3, 5]中。<br>

提示：<br>
1 <= n <= 10^6<br>
1 <= primes.length <= 100<br>
2 <= primes[i] <= 1000<br>
题目数据保证primes[i]是一个质数<br>
primes中的所有值都互不相同，且按增顺序排列<br>

[Link](https://leetcode-cn.com/problems/super-ugly-number/)