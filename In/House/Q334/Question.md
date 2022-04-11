<h1>递增的三元子序列</h1>

给你一个整数数组nums，判断这个数组中是否存在长度为3的递增子序列。</br>
如果存在这样的三元组下标(i, j, k)且满足i < j < k，使得nums[i] < nums[j] < nums[k]，返回true；否则，返回false。</br>

示例1：</br>
输入：nums = [1, 2, 3, 4, 5]</br>
输出：true</br>
解释：任何i < j < k的三元组都满足题意</br>

示例2：</br>
输入：nums = [5, 4, 3, 2, 1]</br>
输出：false</br>
解释：不存在满足题意的三元组</br>

示例3：</br>
输入：nums = [2, 1, 5, 0, 4, 6]</br>
输出：true</br>
解释：三元组(3, 4, 5)满足题意，因为nums[3] == 0 < nums[4] == 4 < nums[5] == 6</br>

提示：</br>
1 <= nums.length <= 5 * 10^5</br>
-2^31 <= nums[i] <= 2^31 - 1</br>
</br>
进阶：你能实现时间复杂度为O(n)，空间复杂度为O(1)的解决方案吗？</br>

[Link](https://leetcode-cn.com/problems/increasing-triplet-subsequence/)
