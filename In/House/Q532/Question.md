<h1>数组中的k-diff数对</h1>

给定一个整数数组和一个整数k，你需要在数组里找到不同的k-diff数对，并返回不同的k-diff数对的数目。</br>
这里将k-diff数对定义为一个整数对(nums[i], nums[j])，并满足下述全部条件：</br>
- 0 <= i < j < nums.length</br>
- |nums[i] - nums[j]| == k</br>

注意，|val|表示val的绝对值。</br>

示例1：</br>
输入：nums = [3, 1, 4, 1, 5], k = 2</br>
输出：2</br>
解释：数组中有两个2-diff数对, (1, 3)和(3, 5)。</br>
尽管数组中有两个1，但我们只应返回不同的数对的数量。</br>

示例2：</br>
输入：nums = [1, 2, 3, 4, 5], k = 1</br>
输出：4</br>
解释：数组中有四个1-diff数对, (1, 2), (2, 3), (3, 4)和(4, 5)。</br>

示例3：</br>
输入：nums = [1, 3, 1, 5, 4], k = 0</br>
输出：1</br>
解释：数组中只有一个0-diff数对，(1, 1)。</br>

提示：
- 1 <= nums.length <= 10^4
- -10^7 <= nums[i] <= 10^7
- 0 <= k <= 10^7

[Link](https://leetcode.cn/problems/k-diff-pairs-in-an-array/)