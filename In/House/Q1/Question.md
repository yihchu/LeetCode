<h1>两数之和</h1>

给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。</br>
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。</br>
你可以按任意顺序返回答案。</br>

示例1：</br>
输入：nums = [2, 7, 11, 15], target = 9</br>
输出：[0, 1]</br>
解释：因为nums[0] + nums[1] == 9，返回[0, 1]。</br>

示例2：</br>
输入：nums = [3, 2, 4], target = 6</br>
输出：[1, 2]</br>

示例3：</br>
输入：nums = [3, 3], target = 6</br>
输出：[0, 1]</br>

提示：
- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
- 只会存在一个有效答案

进阶：你可以想出一个时间复杂度小于O(n^2)的算法吗？</br>

[Link](https://leetcode-cn.com/problems/two-sum/)