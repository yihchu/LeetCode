<h1>访问所有节点的最短路径</h1>

存在一个由n个节点组成的无向连通图，图中的节点按从0到n - 1编号。</br>
给你一个数组graph表示这个图。其中，graph[i]是一个列表，由所有与节点i直接相连的节点组成。</br>
返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入：graph = [[1, 2, 3], [0], [0], [0]]</br>
输出：4</br>
解释：一种可能的路径为[1, 0, 2, 0, 3]</br>

示例2：</br>
</br>![](./image/2.jpeg)</br></br>
输入：graph = [[1], [0, 2, 4], [1, 3, 4], [2], [1, 2]]</br>
输出：4</br>
解释：一种可能的路径为[0, 1, 4, 2, 3]</br>

提示：
- n == graph.length
- 1 <= n <= 12
- 0 <= graph[i].length < n
- graph[i]不包含i
- 如果graph[a]包含b，那么graph[b]也包含a
- 输入的图总是连通图

[Link](https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/)