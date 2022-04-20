<h1>扁平化多级双向链表</h1>

你会得到一个双链表，其中包含的节点有一个下一个指针、一个前一个指针和一个额外的子指针。这个子指针可能指向一个单独的双向链表，也包含这些特殊的节点。这些子列表可以有一个或多个自己的子列表，以此类推，以生成如下面的示例所示的多层数据结构。</br>
给定链表的头节点head，将链表扁平化，以便所有节点都出现在单层双链表中。让curr是一个带有子列表的节点。子列表中的节点应该出现在扁平化列表中的curr之后和curr.next之前。</br>
返回扁平列表的head。列表中的节点必须将其所有子指针设置为null。</br>

示例1：</br>
</br>![](./image/1.jpeg)</br></br>
输入：head = [1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12]</br>
输出：[1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6]</br>
解释：输入的多级列表如上图所示。</br>
扁平化后的链表如下图：</br>
</br>![](./image/2.jpeg)</br></br>

示例2：</br>
</br>![](./image/3.jpeg)</br></br>
输入：head = [1, 2, null, 3]</br>
输出：[1, 3, 2]</br>
解释：输入的多级列表如上图所示。</br>
扁平化后的链表如下图：</br>
</br>![](./image/4.jpeg)</br></br>

示例3：</br>
输入：head = []</br>
输出：[]</br>
说明：输入中可能存在空列表。</br>

提示：</br>
节点数目不超过1000</br>
1 <= Node.val <= 10^5</br>

如何表示测试用例中的多级链表？</br>
以示例1为例：</br>

    1---2---3---4---5---6--NULL
    |
    7---8---9---10--NULL
    |
    11--12--NULL

序列化其中的每一级之后：</br>

    [1,2,3,4,5,6,null]
    [7,8,9,10,null]
    [11,12,null]

为了将每一级都序列化到一起，我们需要每一级中添加值为null的元素，以表示没有节点连接到上一级的上级节点。</br>

    [1,2,3,4,5,6,null]
    [null,null,7,8,9,10,null]
    [null,11,12,null]

合并所有序列化结果，并去除末尾的null。</br>
    
    [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

[Link](https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/)