<h1>使所有区间的异或结果为零</h1>

给你一个整数数组nums和一个整数k。区间[left, right]（left <= right）的异或结果是对下标位于left和right（包括left和right）之间所有元素进行XOR运算的结果：nums[left] XOR nums[left + 1] XOR ... XOR nums[right]。</br>
返回数组中要更改的最小元素数，以使所有长度为k的区间异或结果等于零。</br>
f(i, j) = size + min(f(i - 1, j), f(i - 1, j^x) - count[x])</br>

示例1：</br>
输入：nums = [1, 2, 0, 3, 0], k = 1</br>
输出：3</br>
解释：将数组[1, 2, 0, 3, 0]修改为[0, 0, 0, 0, 0]</br>

示例2：</br>
输入：nums = [3, 4, 5, 2, 1, 7, 3, 4, 7], k = 3</br>
输出：3</br>
解释：将数组[3, 4, 5, 2, 1, 7, 3, 4, 7]修改为[3, 4, 7, 3, 4, 7, 3, 4, 7]</br>

示例3：</br>
输入：nums = [1, 2, 4, 1, 2, 5, 1, 2, 6], k = 3</br>
输出：3</br>
解释：将数组[1, 2, 4, 1, 2, 5, 1, 2, 6]修改为[1, 2, 3, 1, 2, 3, 1, 2, 3]</br>

提示：</br>
1 <= k <= nums.length <= 2000</br>
0 <= nums[i] < 2^10</br>

[Link](https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/)