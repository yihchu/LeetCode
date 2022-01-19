package In.House.Q237;

import java.util.Objects;

/**
 * 这题本身挺简单，但是题目描述实在是让人看不懂
 */
public class Solution {

    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while (Objects.nonNull(node.next)) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    private static ListNode toNode(int[] array) {
        ListNode h, t;
        h = t = new ListNode(-1);
        for (int a: array) {
            t.next = new ListNode(a);
            t = t.next;
        }
        return h.next;
    }

    private static void print(ListNode node) {
        while (Objects.nonNull(node)) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        ListNode h1 = toNode(new int[] {4, 5, 1, 9});
        slt.deleteNode(h1.next);
        print(h1);

        ListNode h2 = toNode(new int[] {4, 5, 1, 9});
        slt.deleteNode(h2.next.next);
        print(h2);

        ListNode h3 = toNode(new int[] {1, 2, 3, 4});
        slt.deleteNode(h3.next.next);
        print(h3);

        ListNode h4 = toNode(new int[] {0, 1});
        slt.deleteNode(h4);
        print(h4);

        ListNode h5 = toNode(new int[] {-3, 5, -99});
        slt.deleteNode(h5);
        print(h5);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
Ques: 删除链表中的节点
Link: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/

请编写一个函数，用于删除单链表中某个特定节点。在设计函数时需要注意，你无法访问链表的头节点head，只能直接访问要被删除的节点。
题目数据保证需要删除的节点不是末尾节点 。

示例1(图1.jpg)：
输入：head = [4, 5, 1, 9], node = 5
输出：[4, 1, 9]
解释：指定链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为4 -> 1 -> 9

示例2(图2.jpg)：
输入：head = [4, 5, 1, 9], node = 1
输出：[4, 5, 9]
解释：指定链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为4 -> 5 -> 9

示例3：
输入：head = [1, 2, 3, 4], node = 3
输出：[1, 2, 4]

示例4：
输入：head = [0, 1], node = 0
输出：[1]

示例5：
输入：head = [-3, 5, -99], node = -3
输出：[5, -99]

提示：
链表中节点的数目范围是[2, 1000]
-1000 <= Node.val <= 1000
链表中每个节点的值都是唯一的
需要删除的节点node是链表中的一个有效节点，且不是末尾节点

*/