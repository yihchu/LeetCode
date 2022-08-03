<h1>路径总和III</h1>

给定一个二叉树的根节点root，和一个整数targetSum，求该二叉树里节点值之和等于targetSum的路径的数目。</br>
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</br>

示例1：</br>
输入：root = [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1], targetSum = 8</br>
输出：3</br>
解释：和等于8的路径有3条，如图所示。</br>
</br>![](./image/1.jpg)</br></br>

示例2：</br>
输入：root = [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1], targetSum = 22</br>
输出：3</br>

提示:
- 二叉树的节点个数的范围是[0, 1000]
- -10^9 <= Node.val <= 10^9
- -1000 <= targetSum <= 1000

[Link](https://leetcode-cn.com/problems/path-sum-iii/)