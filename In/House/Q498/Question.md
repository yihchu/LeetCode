</br>对角线遍历</br>
     
给你一个大小为m x n的矩阵mat，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入：mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]</br>
输出：[1, 2, 4, 7, 5, 3, 6, 8, 9]</br>

示例2：</br>
输入：mat = [[1, 2], [3, 4]]</br>
输出：[1, 2, 3, 4]</br>

提示：</br>
m == mat.length</br>
n == mat[i].length</br>
1 <= m, n <= 10^4</br>
1 <= m * n <= 10^4</br>
-10^5 <= mat[i][j] <= 10^5</br>

[Link](https://leetcode.cn/problems/diagonal-traverse/)

2 3 -> 4
1 2 3
4 5 6

2 4 -> 5
1 2 3 4
5 6 7 8

1 2 34

1 2
3 4
5 6