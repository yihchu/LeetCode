package Sword.to.Offer.V1.Q22;

import java.util.Objects;

public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }
        ListNode tNode = head, kNode = head;
        for (int i = 0; i < k - 1; ++i) {
            kNode = kNode.next;
            if (Objects.isNull(kNode)) {
                return null;
            }
        }
        while (Objects.nonNull(kNode.next)) {
            tNode = tNode.next;
            kNode = kNode.next;
        }
        return tNode;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        ListNode result1 = slt.getKthFromEnd(buildList(new int[]{1, 2, 3, 4, 5}), 6);
        System.out.println(Objects.nonNull(result1) ? result1.val : "null"); // 4 -> 5

    }

    private static ListNode buildList(int[] array) {
        int len = array.length;
        if (len < 1) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode tail = head;
        for (int i = 1; i < len; ++i) {
            tail.next = new ListNode(array[i]);
            tail = tail.next;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
Ques: 链表中倒数第k个节点
Link: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

示例：
给定一个链表: 1 -> 2 -> 3 -> 4 -> 5, 和 k = 2.
返回链表 4 -> 5.

*/