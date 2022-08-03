<h1>在排序数组中查找元素的第一个和最后一个位置</h1>

给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。</br>
如果数组中不存在目标值target，返回[-1, -1]。</br>

进阶：</br>
你可以设计并实现时间复杂度为O(logn)的算法解决此问题吗？</br>

示例1：</br>
输入：nums = [5, 7, 7, 8, 8, 10], target = 8</br>
输出：[3, 4]</br>

示例2：</br>
输入：nums = [5, 7, 7, 8, 8, 10], target = 6</br>
输出：[-1, -1]</br>

示例3：</br>
输入：nums = [], target = 0</br>
输出：[-1, -1]</br>

提示：
- 0 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- nums是一个非递减数组
- -10^9 <= target <= 10^9

[Link](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)