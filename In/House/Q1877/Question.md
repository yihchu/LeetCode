<h1>数组中最大数对和的最小值</h1>

一个数对(a, b)的数对和等于a + b。最大数对和是一个数对数组中最大的数对和。</br>

比方说，如果我们有数对(1, 5)，(2, 3)和(4, 4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。</br>
给你一个长度为偶数n的数组nums，请你将nums中的元素分成n/2个数对，使得：</br>

nums中每个元素恰好在一个数对中，且最大数对和的值最小。</br>
请你在最优数对划分的方案下，返回最小的最大数对和。</br>

示例1：</br>
输入：nums = [3, 5, 2, 3]</br>
输出：7</br>
解释：数组中的元素可以分为数对(3, 3)和(5, 2)。</br>
最大数对和为max(3 + 3, 5 + 2) = max(6, 7) = 7。</br>

示例2：</br>
输入：nums = [3, 5, 4, 2, 4, 6]</br>
输出：8</br>
解释：数组中的元素可以分为数对(3, 5)，(4, 4)和(6, 2)。</br>
最大数对和为max(3 + 5, 4 + 4, 6 + 2) = max(8, 8, 8) = 8。</br>

提示：</br>
n == nums.length</br>
2 <= n <= 10^5 n是偶数。</br>
1 <= nums[i] <= 10^5</br>

[Link](https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/)