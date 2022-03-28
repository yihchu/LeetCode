<h1>二叉树中所有距离为K的结点</h1>

给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值K。</br>
返回到目标结点target距离为K的所有结点的值的列表。答案可以以任何顺序返回。</br>

示例1：</br>
</br>![](./image/1.png)</br></br>
输入：root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], target = 5, K = 2</br>
输出：[7, 4, 1]</br>
解释：</br>
所求结点为与目标结点（值为5）距离为2的结点，值分别为7，4，以及1</br>
注意，输入的 "root" 和 "target" 实际上是树上的结点。</br>
上面的输入仅仅是对这些对象进行了序列化描述。</br>

提示：</br>
给定的树是非空的。</br>
树上的每个结点都具有唯一的值0 <= node.val <= 500。</br>
目标结点target是树上的结点。</br>
0 <= K <= 1000.</br>

[Link](https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/)