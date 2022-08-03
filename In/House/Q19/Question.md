<h1>删除链表的倒数第N个结点</h1>

给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入：head = [1, 2, 3, 4, 5], n = 2</br>
输出：[1, 2, 3, 5]</br>

示例2：</br>
输入：head = [1], n = 1</br>
输出：[]</br>

示例3：</br>
输入：head = [1, 2], n = 1</br>
输出：[1]</br>

提示：
- 链表中结点的数目为sz
- 1 <= sz <= 30
- 0 <= Node.val <= 100
- 1 <= n <= sz

进阶：你能尝试使用一趟扫描实现吗？</br>

[Link](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)