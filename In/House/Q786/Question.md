<h1>第K个最小的素数分数</h1>

给你一个按递增顺序排序的数组arr和一个整数k。数组arr由1和若干素数组成，且其中所有整数互不相同。</br>
对于每对满足0 < i < j < arr.length的i和j，可以得到分数arr[i] / arr[j]。
那么第k个最小的分数是多少呢?以长度为2的整数数组返回你的答案, 这里answer[0] == arr[i]且answer[1] == arr[j]。</br>

示例1：</br>
输入：arr = [1, 2, 3, 5], k = 3</br>
输出：[2, 5]</br>
解释：已构造好的分数,排序后如下所示:</br>
1/5, 1/3, 2/5, 1/2, 3/5, 2/3</br>
很明显第三个最小的分数是2/5</br>

示例2：</br>
输入：arr = [1, 7], k = 1</br>
输出：[1, 7]</br>

提示：</br>
2 <= arr.length <= 1000</br>
1 <= arr[i] <= 3 * 10^4</br>
arr[0] == 1</br>
arr[i]是一个素数，i > 0</br>
arr中的所有数字互不相同，且按严格递增排序</br>
1 <= k <= arr.length * (arr.length - 1) / 2</br>

[Link](https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/)