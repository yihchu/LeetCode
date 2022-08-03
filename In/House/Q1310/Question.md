<h1>子数组异或查询</h1>

有一个正整数数组arr，现给你一个对应的查询数组queries，其中queries[i] = [L[i], R[i]]。</br>
对于每个查询i，请你计算从L[i]到R[i]的XOR值（即arr[L[i]] xor arr[L[i]+1] xor ... xor arr[R[i]]）作为本次查询的结果。</br>
并返回一个包含给定查询queries所有结果的数组。</br>

示例1：</br>
输入：arr = [1, 3, 4, 8], queries = [[0, 1], [1, 2], [0, 3], [3, 3]]</br>
输出：[2, 7, 14, 8]</br>
解释：</br>
数组中元素的二进制表示形式是：</br>
1 = 0001</br>
3 = 0011</br>
4 = 0100</br>
8 = 1000</br>
查询的XOR值为：</br>
[0, 1] = 1 xor 3 = 2</br>
[1, 2] = 3 xor 4 = 7</br>
[0, 3] = 1 xor 3 xor 4 xor 8 = 14</br>
[3, 3] = 8</br>

示例2：</br>
输入：arr = [4, 8, 2, 10], queries = [[2, 3], [1, 3], [0, 0], [0, 3]]</br>
输出：[8, 0, 4, 4]</br>

提示：
- 1 <= arr.length <= 3 * 10^4
- 1 <= arr[i] <= 10^9
- 1 <= queries.length <= 3 * 10^4
- queries[i].length == 2
- 0 <= queries[i][0] <= queries[i][1] < arr.length

[Link](https://leetcode-cn.com/problems/xor-queries-of-a-subarray/)