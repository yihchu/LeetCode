<h1>找出第K小的数对距离</h1>

数对(a, b)由整数a和b组成，其数对距离定义为a和b的绝对差值。</br>
给你一个整数数组nums和一个整数k，数对由nums[i]和nums[j]组成且满足0 <= i < j < nums.length。返回所有数对距离中第k小的数对距离。</br>

示例1：</br>
输入：nums = [1, 3, 1], k = 1</br>
输出：0</br>
解释：数对和对应的距离如下：</br>
(1, 3) -> 2</br>
(1, 1) -> 0</br>
(3, 1) -> 2</br>
距离第1小的数对是(1, 1)，距离为0。</br>

示例2：</br>
输入：nums = [1, 1, 1], k = 2</br>
输出：0</br>

示例3：</br>
输入：nums = [1, 6, 1], k = 3</br>
输出：5</br>

提示：
- n == nums.length
- 2 <= n <= 10^4
- 0 <= nums[i] <= 10^6
- 1 <= k <= n * (n - 1) / 2

[Link](https://leetcode.cn/problems/find-k-th-smallest-pair-distance/)