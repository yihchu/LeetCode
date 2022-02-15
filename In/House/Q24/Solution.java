package In.House.Q24;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode l1 = head, l2 = head.next, l3 = head.next.next;
        ListNode h = null, t = null;
        while (true) {
            l1.next = l3;
            l2.next = l1;
            if (Objects.isNull(h)) {
                h = l2;
                t = l1;
            } else {
                t.next = l2;
                t = t.next.next;
            }
            if (Objects.isNull(l3)) {
                break;
            }
            l1 = l3;
            if (Objects.isNull(l1.next)) {
                t.next = l1;
                t = t.next;
                break;
            }
            l2 = l1.next;
            l3 = l2.next;
        }
        return h;
    }

    private static ListNode toList(int[] arr) {
        ListNode head = null, tail = null;
        for (int a: arr) {
            if (Objects.isNull(head)) {
                head = tail = new ListNode(a);
                continue;
            }
            tail.next = new ListNode(a);
            tail = tail.next;
        }
        return head;
    }

    private static void print(ListNode root) {
        ListNode tmp = root;
        while (Objects.nonNull(tmp)) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.swapPairs(toList(new int[] {1, 2, 3, 4}))); // [2, 1, 4, 3]
        print(slt.swapPairs(toList(new int[] {1, 2, 3, 4, 5}))); // [2, 1, 4, 3, 5]
        print(slt.swapPairs(toList(new int[] {1, 2, 3}))); // [2, 1, 3]
        print(slt.swapPairs(toList(new int[] {1, 2}))); // [2, 1]
        print(slt.swapPairs(toList(new int[] { }))); // [ ]
        print(slt.swapPairs(toList(new int[] {1}))); // [1]
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
Ques: 两两交换链表中的节点
Link: https://leetcode-cn.com/problems/swap-nodes-in-pairs/

给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

示例1(图1.jpeg)：
输入：head = [1, 2, 3, 4]
输出：[2, 1, 4, 3]

示例2：
输入：head = []
输出：[]

示例3：
输入：head = [1]
输出：[1]

提示：
链表中节点的数目在范围[0, 100]内
0 <= Node.val <= 100
*/