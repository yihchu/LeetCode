<h1>球会落何处</h1>

用一个大小为m x n的二维网格grid表示一个箱子。你有n颗球。箱子的顶部和底部都是开着的。</br>
箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。</br>
将球导向右侧的挡板跨过左上角和右下角，在网格中用1表示。</br>
将球导向左侧的挡板跨过右上角和左下角，在网格中用-1表示。</br>
在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的"V"形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。</br>
返回一个大小为n的数组answer，其中answer[i]是球放在顶部的第i列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回-1。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入：grid = [[1, 1, 1, -1, -1], [1, 1, 1, -1, -1], [-1, -1, -1, 1, 1], [1, 1, 1, 1, -1], [-1, -1, -1, -1, -1]]</br>
输出：[1, -1, -1, -1, -1]</br>
解释：</br>
b0球开始放在第0列上，最终从箱子底部第1列掉出。</br>
b1球开始放在第1列上，会卡在第2、3列和第1行之间的"V"形里。</br>
b2球开始放在第2列上，会卡在第2、3列和第0行之间的"V"形里。</br>
b3球开始放在第3列上，会卡在第2、3列和第0行之间的"V"形里。</br>
b4球开始放在第4列上，会卡在第2、3列和第1行之间的"V"形里。</br>

示例2：</br>
输入：grid = [[-1]]</br>
输出：[-1]</br>
解释：球被卡在箱子左侧边上。</br>

示例3：</br>
输入：grid = [[1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1], [1, 1, 1, 1, 1, 1], [-1, -1, -1, -1, -1, -1]]</br>
输出：[0, 1, 2, 3, 4, -1]</br>

提示：</br>
m == grid.length</br>
n == grid[i].length</br>
1 <= m, n <= 100</br>
grid[i][j]为1或-1</br>

[Link](https://leetcode-cn.com/problems/where-will-the-ball-fall/)