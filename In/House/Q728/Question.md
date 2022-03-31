<h1>自除数</h1>

自除数是指可以被它包含的每一位数整除的数。</br>
例如，128是一个自除数，因为128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。</br>
自除数不允许包含0。</br>
给定两个整数left和right，返回一个列表，列表的元素是范围[left, right]内所有的自除数。</br>

示例1：</br>
输入：left = 1, right = 22</br>
输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]</br>

示例2:</br>
输入：left = 47, right = 85</br>
输出：[48, 55, 66, 77]

提示：
1 <= left <= right <= 10^4

[Link](https://leetcode-cn.com/problems/self-dividing-numbers/)