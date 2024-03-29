<h1>删除二叉搜索树中的节点</h1>

给定一个二叉搜索树的根节点root和一个值key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。</br>
一般来说，删除节点可分为两个步骤：</br>
首先找到需要删除的节点；</br>
如果找到了，删除它。</br>

示例1:</br>
</br>![](./image/1.jpeg)</br></br>
输入：root = [5, 3, 6, 2, 4, null, 7], key = 3</br>
输出：[5, 4, 6, 2, null, null, 7]</br>
解释：给定需要删除的节点值是3，所以我们首先找到 3 这个节点，然后删除它。</br>
一个正确的答案是 [5, 4, 6, 2, null, null, 7], 如下图所示。</br>
另一个正确答案是 [5, 2, 6, null, 4, null, 7]。</br>
</br>![](./image/2.jpeg)</br></br>

示例2:</br>
输入: root = [5, 3, 6, 2, 4, null, 7], key = 0</br>
输出: [5, 3, 6, 2, 4, null, 7]</br>
解释: 二叉树不包含值为0的节点</br>

示例3:</br>
输入: root = [], key = 0</br>
输出: []</br>

提示:
- 节点数的范围 [0, 10^4].
- -10^5 <= Node.val <= 10^5
- 节点值唯一
- root是合法的二叉搜索树
- -10^5 <= key <= 10^5

进阶：要求算法时间复杂度为O(h)，h为树的高度。</br>

[Link](https://leetcode.cn/problems/delete-node-in-a-bst/)