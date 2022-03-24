<h1>存在重复元素II</h1>

给你一个整数数组nums和一个整数k，判断数组中是否存在两个不同的索引i和j，满足`nums[i] == nums[j]`且`abs(i - j) <= k`。如果存在，返回true；否则，返回false。</br>

示例1：</br>
输入：nums = [1, 2, 3, 1], k = 3</br>
输出：true</br>

示例2：</br>
输入：nums = [1, 0, 1, 1], k = 1</br>
输出：true</br>

示例3：</br>
输入：nums = [1, 2, 3, 1, 2, 3], k = 2</br>
输出：false</br>

提示：</br>
1 <= nums.length <= 10^5</br>
-10^9 <= nums[i] <= 10^9</br>
0 <= k <= 10^5</br>

[Link](https://leetcode-cn.com/problems/contains-duplicate-ii/)