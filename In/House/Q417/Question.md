<h1>太平洋大西洋水流问题</h1>

有一个m × n的矩形岛屿，与太平洋和大西洋相邻。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。</br>
这个岛被分割成一个由若干方形单元格组成的网格。给定一个m x n的整数矩阵heights，heights[r][c]表示坐标(r, c)上单元格高于海平面的高度。</br>
岛上雨水较多，如果相邻单元格的高度小于或等于当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。</br>
返回网格坐标result的2D列表，其中result[i] = [r[i], c[i]]表示雨水可以从单元格(r[i], c[i])流向太平洋和大西洋。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入: heights = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]</br>
输出: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]</br>

示例2：</br>
输入: heights = [[2, 1], [1, 2]]</br>
输出: [[0, 0], [0, 1], [1, 0], [1, 1]]</br>

提示：</br>
m == heights.length</br>
n == heights[r].length</br>
1 <= m, n <= 200</br>
0 <= heights[r][c] <= 10^5</br>

[Link](https://leetcode-cn.com/problems/pacific-atlantic-water-flow/)