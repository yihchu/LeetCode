<h1>K站中转内最便宜的航班</h1>

有n个城市通过一些航班连接。给你一个数组flights，其中flights[i] = [from[i], to[i], price[i]]，表示该航班都从城市from[i]开始，以价格price[i]抵达to[i]。</br>
现在给定所有的城市和航班，以及出发城市src和目的地dst，你的任务是找到出一条最多经过k站中转的路线，使得从src到dst的价格最便宜，并返回该价格。如果不存在这样的路线，则输出-1。</br>

示例1：</br>
输入:</br>
n = 3, edges = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]</br>
src = 0, dst = 2, k = 1</br>
输出: 200</br>
解释:</br>
城市航班图如下</br>
</br>![](./image/1.png)</br></br>
从城市0到城市2在1站中转以内的最便宜价格是200，如图中红色所示。</br>

示例2：</br>
输入:</br>
n = 3, edges = [[0, 1, 100], [1, 2, 100], [0, 2, 500]]</br>
src = 0, dst = 2, k = 0</br>
输出: 500</br>
解释:</br>
城市航班图如下</br>
</br>![](./image/2.png)</br></br>
从城市0到城市2在0站中转以内的最便宜价格是500，如图中蓝色所示。</br>

提示：</br>
1 <= n <= 100</br>
0 <= flights.length <= (n * (n - 1) / 2)</br>
flights[i].length == 3</br>
0 <= from[i], to[i] < n</br>
from[i] != to[i]</br>
1 <= price[i] <= 10^4</br>
航班没有重复，且不存在自环</br>
0 <= src, dst, k < n</br>
src != dst</br>

[Link](https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/)
