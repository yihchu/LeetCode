<h1>获取生成数组中的最大值</h1>

给你一个整数n。按下述规则生成一个长度为n + 1的数组nums：</br>
nums[0] = 0</br>
nums[1] = 1</br>
当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]</br>
当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]</br>
返回生成数组nums中的最大值。</br>

示例1：</br>
输入：n = 7</br>
输出：3</br>
解释：根据规则：</br>
nums[0] = 0</br>
nums[1] = 1</br>
nums[(1 * 2) = 2] = nums[1] = 1</br>
nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2</br>
nums[(2 * 2) = 4] = nums[2] = 1</br>
nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3</br>
nums[(3 * 2) = 6] = nums[3] = 2</br>
nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3</br>
因此，nums = [0, 1, 1, 2, 1, 3, 2, 3]，最大值3</br>

示例2：</br>
输入：n = 2</br>
输出：1</br>
解释：根据规则，nums[0]、nums[1]和nums[2]之中的最大值是1</br>

示例3：</br>
输入：n = 3</br>
输出：2</br>
解释：根据规则，nums[0]、nums[1]、nums[2]和nums[3]之中的最大值是2</br>

提示：
- 0 <= n <= 100

[Link](https://leetcode-cn.com/problems/get-maximum-in-generated-array/)