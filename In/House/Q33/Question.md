<h1>搜索旋转排序数组</h1>

整数数组nums按升序排列，数组中的值互不相同。</br>
在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。例如，[0, 1, 2, 4, 5, 6, 7]在下标3处经旋转后可能变为[4, 5, 6, 7, 0, 1, 2]。</br>
给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1。</br>

示例1：</br>
输入：nums = [4, 5, 6, 7, 0, 1, 2], target = 0</br>
输出：4</br>

示例2：</br>
输入：nums = [4, 5, 6, 7, 0, 1, 2], target = 3</br>
输出：-1</br>

示例3：</br>
输入：nums = [1], target = 0</br>
输出：-1</br>

提示：</br>
1 <= nums.length <= 5000</br>
-10^4 <= nums[i] <= 10^4</br>
nums中的每个值都独一无二</br>
题目数据保证nums在预先未知的某个下标上进行了旋转</br>
-10^4 <= target <= 10^4</br>

进阶：你可以设计一个时间复杂度为O(log n)的解决方案吗？</br>

[Link](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)