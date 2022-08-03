<h1>数组异或操作</h1>

给你两个整数，n和start。</br>
数组nums定义为：nums[i] = start + 2 * i（下标从0开始）且n == nums.length。</br>
请返回nums中所有元素按位异或（XOR）后得到的结果。</br>

示例1：</br>
输入：n = 5, start = 0</br>
输出：8</br>
解释：数组nums为[0, 2, 4, 6, 8]，其中(0 ^ 2 ^ 4 ^ 6 ^ 8) = 8。"^"为按位异或XOR运算符。</br>

示例2：</br>
输入：n = 4, start = 3</br>
输出：8</br>
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.</br>

示例3：</br>
输入：n = 1, start = 7</br>
输出：7</br>

示例4：</br>
输入：n = 10, start = 5</br>
输出：2</br>

提示：
- 1 <= n <= 1000
- 0 <= start <= 1000
- n == nums.length

[Link](https://leetcode-cn.com/problems/xor-operation-in-an-array/)