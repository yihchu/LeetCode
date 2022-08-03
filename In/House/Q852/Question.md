<h1>山脉数组的峰顶索引</h1>

符合下列属性的数组arr称为山脉数组：</br>
arr.length >= 3</br>
存在i（0 < i < arr.length - 1）使得：</br>
arr[0] < arr[1] < ... arr[i-1] < arr[i]</br>
arr[i] > arr[i+1] > ... > arr[arr.length - 1]</br>
给你由整数组成的山脉数组arr，返回任何满足arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]的下标i。</br>

示例1：</br>
输入：arr = [0, 1, 0]</br>
输出：1</br>

示例2：</br>
输入：arr = [0, 2, 1, 0]</br>
输出：1</br>

示例3：</br>
输入：arr = [0, 10, 5, 2]</br>
输出：1</br>

示例4：</br>
输入：arr = [3, 4, 5, 1]</br>
输出：2</br>

示例5：</br>
输入：arr = [24, 69, 100, 99, 79, 78, 67, 36, 26, 19]</br>
输出：2</br>

提示：
- 3 <= arr.length <= 10^4
- 0 <= arr[i] <= 10^6
- 题目数据保证arr是一个山脉数组

[Link](https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/)