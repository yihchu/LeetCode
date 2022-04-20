<h1>子数组范围和</h1>

给你一个整数数组nums。nums中，子数组的范围是子数组中最大元素和最小元素的差值。</br>
返回nums中所有子数组范围的和。</br>
子数组是数组中一个连续非空的元素序列。</br>

示例1：</br>
输入：nums = [1, 2, 3]</br>
输出：4</br>
解释：nums的6个子数组如下所示：</br>
[1]，范围 = 最大 - 最小 = 1 - 1 = 0</br>
[2]，范围 = 2 - 2 = 0</br>
[3]，范围 = 3 - 3 = 0</br>
[1, 2]，范围 = 2 - 1 = 1</br>
[2, 3]，范围 = 3 - 2 = 1</br>
[1, 2, 3]，范围 = 3 - 1 = 2</br>
所有范围的和是0 + 0 + 0 + 1 + 1 + 2 = 4</br>

示例2：</br>
输入：nums = [1, 3, 3]</br>
输出：4</br>
解释：nums的6个子数组如下所示：</br>
[1]，范围 = 最大 - 最小 = 1 - 1 = 0</br>
[3]，范围 = 3 - 3 = 0</br>
[3]，范围 = 3 - 3 = 0</br>
[1, 3]，范围 = 3 - 1 = 2</br>
[3, 3]，范围 = 3 - 3 = 0</br>
[1, 3, 3]，范围 = 3 - 1 = 2</br>
所有范围的和是0 + 0 + 0 + 2 + 0 + 2 = 4</br>

示例3：</br>
输入：nums = [4, -2, -3, 4, 1]</br>
输出：59</br>
解释：nums中所有子数组范围的和是59</br>

提示：</br>
1 <= nums.length <= 1000</br>
-10^9 <= nums[i] <= 10^9</br>

进阶：你可以设计一种时间复杂度为O(n)的解决方案吗？</br>

[Link](https://leetcode-cn.com/problems/sum-of-subarray-ranges/)