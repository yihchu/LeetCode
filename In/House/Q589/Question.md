<h1>N叉树的前序遍历</h1>

给定一个n叉树的根节点root，返回其节点值的前序遍历。</br>
n叉树在输入中按层序遍历进行序列化表示，每组子节点由空值null分隔（请参见示例）。</br>

示例1：</br>
</br>![](./image/1.png)</br></br>
输入：root = [1, null, 3, 2, 4, null, 5, 6]</br>
输出：[1, 3, 5, 6, 2, 4]</br>

示例2：</br>
</br>![](./image/2.png)</br></br>
输入：root = [1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14]</br>
输出：[1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]</br>

提示：
- 节点总数在范围 [0, 10^4]内
- 0 <= Node.val <= 10^4
- n叉树的高度小于或等于1000

进阶：递归法很简单，你可以使用迭代法完成此题吗?</br>

[Link](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)