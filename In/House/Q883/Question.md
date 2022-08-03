<h1>三维形体投影面积</h1>

在n x n的网格grid中，我们放置了一些与x，y，z三轴对齐的1 x 1 x 1立方体。</br>
每个值v = grid[i][j]表示v个正方体叠放在单元格(i, j)上。</br>
现在，我们查看这些立方体在xy、yz和zx平面上的投影。</br>
投影就像影子，将三维形体映射到一个二维平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。</br>
返回所有三个投影的总面积。</br>

示例1：</br>
</br>![](./image/1.png)</br></br>
输入：[[1, 2], [3, 4]]</br>
输出：17</br>
解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。</br>

示例2:</br>
输入：grid = [[2]]</br>
输出：5</br>

示例3：</br>
输入：[[1, 0], [0, 2]]</br>
输出：8</br>

提示：
- n == grid.length == grid[i].length
- 1 <= n <= 50
- 0 <= grid[i][j] <= 50

[Link](https://leetcode-cn.com/problems/projection-area-of-3d-shapes/)