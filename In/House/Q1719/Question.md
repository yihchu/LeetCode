<h1>重构一棵树的方案数</h1>

给你一个数组pairs，其中pairs[i] = [x[i], y[i]]，并且满足：</br>
pairs中没有重复元素</br>
x[i] < y[i]</br>
令ways为满足下面条件的有根树的方案数：</br>
树所包含的所有节点值都在pairs中。</br>
一个数对[x[i], y[i]]出现在pairs中当且仅当x[i]是y[i]的祖先或者y[i]是x[i]的祖先。</br>

注意：构造出来的树不一定是二叉树。</br>
两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。</br>

请你返回：</br>
如果ways == 0，返回0。</br>
如果ways == 1，返回1。</br>
如果ways > 1，返回2。</br>
一棵有根树指的是只有一个根节点的树，所有边都是从根往外的方向。</br>
我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的祖先。根节点没有祖先。</br>

示例1(图1.png)：</br>
输入：pairs = [[1, 2], [2, 3]]</br>
输出：1</br>
解释：如上图所示，有且只有一个符合规定的有根树。</br>

示例2(图2.png)：</br>
输入：pairs = [[1, 2], [2, 3], [1, 3]]</br>
输出：2</br>
解释：有多个符合规定的有根树，其中三个如上图所示。</br>

示例3：</br>
输入：pairs = [[1, 2], [2, 3], [2, 4], [1, 5]]</br>
输出：0</br>
解释：没有符合规定的有根树。</br>
(补充解释：</br>
乍一看题，会认为这个例子如果以1为根节点，2，5为其子节点，3，4为2的子节点的话是可以构造出一棵树的。</br>
但是条件中有一句话："一个数对[x[i], y[i]]出现在pairs中当且仅当x[i]是y[i]的祖先或者y[i]是x[i]的祖先。"</br>
这个祖先，并不是只直接祖先，也就是说以上述方式沟造出来的树，1也是3和4的祖先。</br>
那么就要求[1, 3]或者[3, 1]，[1, 4]或者[4, 1]也要存在于pairs当中才可。)</br>

提示：</br>
1 <= pairs.length <= 10^5</br>
1 <= x[i] < y[i] <= 500</br>
pairs中的元素互不相同。</br>

[Link](https://leetcode-cn.com/problems/number-of-ways-to-reconstruct-a-tree/)