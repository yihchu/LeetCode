<h1>四数之和</h1>

给你一个由n个整数组成的数组nums，和一个目标值target。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：</br>
0 <= a, b, c, d < n</br>
a、b、c和d互不相同</br>
nums[a] + nums[b] + nums[c] + nums[d] == target</br>
你可以按任意顺序返回答案。</br>

示例1：</br>
输入：nums = [1, 0, -1, 0, -2, 2], target = 0</br>
输出：[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, s, 1]]</br>

示例2：</br>
输入：nums = [2, 2, 2, 2, 2], target = 8</br>
输出：[[2, 2, 2, 2]]</br>

提示：
- 1 <= nums.length <= 200
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9

[Link](https://leetcode-cn.com/problems/4sum/)