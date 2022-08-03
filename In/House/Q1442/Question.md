<h1>形成两个异或相等数组的三元组数目</h1>

给你一个整数数组arr。</br>
现需要从数组中取三个下标i、j和k ，其中(0 <= i < j <= k < arr.length)。</br>

a和b定义如下：</br>
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[k - 1]</br>
b = arr[k] ^ arr[k + 1] ^ ... ^ arr[j]</br>
注意：^表示按位异或操作。</br>

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。</br>

示例1：</br>
输入：arr = [2, 3, 1, 6, 7]</br>
输出：4</br>
解释：满足题意的三元组分别是(0, 1, 2), (0, 2, 2), (2, 3, 4)以及(2, 4, 4)</br>

示例2：</br>
输入：arr = [1, 1, 1, 1, 1]</br>
输出：10</br>

示例3：</br>
输入：arr = [2, 3]</br>
输出：0</br>

示例4：</br>
输入：arr = [1, 3, 5, 7, 9]</br>
输出：3</br>

示例5：</br>
输入：arr = [7, 11, 12, 9, 5, 2, 7, 17, 22]</br>
输出：8</br>

提示：
- 1 <= arr.length <= 300
- 1 <= arr[i] <= 10^8

[Link](https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/)