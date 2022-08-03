<h1>最小操作次数使数组元素相等</h1>

给你一个长度为n的整数数组，每次操作将会使n - 1个元素增加1。返回让数组所有元素相等的最小操作次数。</br>

示例1：</br>
输入：nums = [1, 2, 3]</br>
输出：3</br>
解释：</br>
只需要3次操作（注意每次操作会增加两个元素的值）：</br>
[1, 2, 3] => [2, 3, 3] => [3, 4, 3] => [4, 4, 4]</br>

示例2：</br>
输入：nums = [1, 1, 1]</br>
输出：0</br>

提示：
- n == nums.length
- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
- 答案保证符合32-bit整数

[Link](https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/)