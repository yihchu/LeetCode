<h1>找到最终的安全状态</h1>

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。</br>
对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是安全的。</br>
返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按升序排列。</br>
该有向图有n个节点，按0到n - 1编号，其中n是graph的节点数。图以下述形式给出：graph[i]是编号j节点的一个列表，满足(i, j)是图的一条有向边。</br>

示例1：</br>
输入：graph = [[1, 2], [2, 3], [5], [0], [5], [], []]</br>
输出：[2, 4, 5, 6]</br>
解释：示意如图1.png。</br>

示例2：</br>
输入：graph = [[1, 2, 3, 4], [1, 2], [3, 4], [0, 4], []]</br>
输出：[4]</br>

提示：</br>
n == graph.length</br>
1 <= n <= 10^4</br>
0 <= graph[i].length <= n</br>
graph[i]按严格递增顺序排列。</br>
图中可能包含自环。</br>
图中边的数目在范围[1, 4 * 10^4]内。</br>

[Link](https://leetcode-cn.com/problems/find-eventual-safe-states/)