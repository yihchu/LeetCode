<h1>非递增顺序的最小子序列</h1>

给你一个数组nums，请你从中抽取一个子序列，满足该子序列的元素之和严格大于未包含在该子序列中的各元素之和。</br>
如果存在多个解决方案，只需返回长度最小的子序列。如果仍然有多个解决方案，则返回元素之和最大的子序列。</br>
与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。</br>
注意，题目数据保证满足所有约束条件的解决方案是唯一的。同时，返回的答案应当按非递增顺序排列。</br>

示例1：</br>
输入：nums = [4, 3, 10, 9, 8]</br>
输出：[10, 9]</br>
解释：子序列[10, 9]和[10, 8]是最小的、满足元素之和大于其他各元素之和的子序列。但是[10, 9]的元素之和最大。</br>

示例2：</br>
输入：nums = [4, 4, 7, 6, 7]</br>
输出：[7, 7, 6]</br>
解释：子序列[7, 7]的和为14，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7, 6, 7]是满足题意的最小子序列。注意，元素按非递增顺序返回。</br>

示例3：</br>
输入：nums = [6]</br>
输出：[6]</br>

提示：
- 1 <= nums.length <= 500
- 1 <= nums[i] <= 100

[Link](https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/)