<h1>三个无重叠子数组的最大和</h1>

给你一个整数数组nums和一个整数k，找出三个长度为k、互不重叠、且3 * k项的和最大的子数组，并返回这三个子数组。</br>
以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从0开始）。如果有多个结果，返回字典序最小的一个。</br>

示例1：</br>
输入：nums = [1, 2, 1, 2, 6, 7, 5, 1], k = 2</br>
输出：[0, 3, 5]</br>
解释：子数组[1, 2], [2, 6], [7, 5]对应的起始下标为[0, 3, 5]。</br>
也可以取[2, 1], 但是结果[1, 3, 5]在字典序上更大。</br>

示例2：</br>
输入：nums = [1, 2, 1, 2, 1, 2, 1, 2, 1], k = 2</br>
输出：[0, 2, 4]</br>

提示：
- 1 <= nums.length <= 2 * 10^4
- 1 <= nums[i] < 2^16
- 1 <= k <= floor(nums.length / 3)

[Link](https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/)