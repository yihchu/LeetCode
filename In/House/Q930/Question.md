<h1>和相同的二元子数组</h1>

给你一个二元数组nums，和一个整数goal，请你统计并返回有多少个和为goal的非空子数组。</br>
子数组是数组的一段连续部分。</br>

示例1：</br>
输入：nums = [1, 0, 1, 0, 1], goal = 2</br>
输出：4</br>
解释：</br>
如下面黑体所示，有4个满足题目要求的子数组：</br>
[1, 0, 1, 0, 1]</br>
[1, 0, 1, 0, 1]</br>
[1, 0, 1, 0, 1]</br>
[1, 0, 1, 0, 1]</br>

示例2：</br>
输入：nums = [0, 0, 0, 0, 0], goal = 0</br>
输出：15</br>

提示：</br>
1 <= nums.length <= 3 * 10^4</br>
nums[i]不是0就是1</br>
0 <= goal <= nums.length</br>

[Link](https://leetcode-cn.com/problems/binary-subarrays-with-sum/)