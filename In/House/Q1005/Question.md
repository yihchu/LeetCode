<h1>K次取反后最大化的数组和</h1>

给你一个整数数组nums和一个整数k，按以下方法修改该数组：</br>
选择某个下标i并将nums[i]替换为-nums[i]。</br>
重复这个过程恰好k次。可以多次选择同一个下标i。</br>
以这种方式修改数组后，返回数组可能的最大和。</br>

示例1：</br>
输入：nums = [4, 2, 3], k = 1</br>
输出：5</br>
解释：选择下标1，nums变为[4, -2, 3]。</br>

示例2：</br>
输入：nums = [3, -1, 0, 2], k = 3</br>
输出：6</br>
解释：选择下标(1, 2, 2)，nums变为[3, 1, 0, 2]。</br>

示例3：</br>
输入：nums = [2, -3, -1, 5, -4], k = 2</br>
输出：13</br>
解释：选择下标(1, 4)，nums变为[2, 3, -1, 5, 4]。</br>

提示：</br>
1 <= nums.length <= 10^4</br>
-100 <= nums[i] <= 100</br>
1 <= k <= 10^4</br>

[Link](https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/)