<h1>找出星型图的中心节点</h1>

有一个无向的星型图，由n个编号从1到n的节点组成。星型图有一个中心节点，并且恰有n - 1条边将中心节点与其他每个节点连接起来。</br>
给你一个二维整数数组edges，其中edges[i] = [u[i], v[i]]表示在节点u[i]和v[i]之间存在一条边。请你找出并返回edges所表示星型图的中心节点。</br>

示例1：</br>
</br>![](./image/1.png)</br></br>
输入：edges = [[1, 2], [2, 3], [4, 2]]</br>
输出：2</br>
解释：如上图所示，节点2与其他每个节点都相连，所以节点2是中心节点。</br>

示例2：</br>
输入：edges = [[1, 2], [5, 1], [1, 3], [1, 4]]</br>
输出：1</br>

提示：</br>
3 <= n <= 10^5</br>
edges.length == n - 1</br>
edges[i].length == 2</br>
1 <= u[i], v[i] <= n</br>
u[i] != v[i]</br>
题目数据给出的edges表示一个有效的星型图</br>

[Link](https://leetcode-cn.com/problems/find-center-of-star-graph/)