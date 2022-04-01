<h1>回旋镖的数量</h1>

给定平面上n对互不相同的点points，其中points[i] = [x[i], y[i]]。回旋镖是由点(i, j, k)表示的元组，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。</br>
返回平面上所有回旋镖的数量。</br>

示例1：</br>
输入：points = [[0, 0], [1, 0], [2, 0]]</br>
输出：2</br>
解释：两个回旋镖为[[1, 0], [0, 0], [2, 0]]和[[1, 0], [2, 0], [0, 0]]</br>

示例2：</br>
输入：points = [[1, 1], [2, 2], [3, 3]]</br>
输出：2</br>
</br>
示例3：</br>
输入：points = [[1, 1]]</br>
输出：0</br>

提示：</br>
n == points.length</br>
1 <= n <= 500</br>
points[i].length == 2</br>
-10^4 <= x[i], y[i] <= 10^4</br>
所有点都互不相同</br>

[Link](https://leetcode-cn.com/problems/number-of-boomerangs/)