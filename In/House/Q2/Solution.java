package In.House.Q2;

import java.util.Objects;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode h = new ListNode();
        ListNode t = h;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int sum = l1.val + l2.val + (flag ? 1 : 0);
            flag = sum > 9;
            t.next = new ListNode(sum % 10);
            t = t.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        l1 = Objects.isNull(l2) ? l1 : l2;
        while (Objects.nonNull(l1)) {
            int sum = l1.val + (flag ? 1 : 0);
            flag = sum > 9;
            t.next = new ListNode(sum % 10);
            t = t.next;
            l1 = l1.next;
        }
        if (flag) {
            t.next = new ListNode(1);
        }
        return h.next;
    }

    private static ListNode toList(int[] array) {
        ListNode h = new ListNode();
        ListNode t = h;
        for (int i = 0; i < array.length; ++i) {
            t.next = new ListNode(array[i]);
            t = t.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.addTwoNumbers(toList(new int[] {2, 4, 3}), toList(new int[] {5, 6, 4})).print();
        slt.addTwoNumbers(toList(new int[] {0}), toList(new int[] {0})).print();
        slt.addTwoNumbers(toList(new int[] {9, 9, 9, 9, 9, 9, 9}), toList(new int[] {9, 9, 9, 9})).print();
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    void print() {
        ListNode tmp = this;
        while (Objects.nonNull(tmp)) {
            System.out.print(tmp.val + (Objects.nonNull(tmp.next) ? " " : ""));
            tmp = tmp.next;
        }
        System.out.println();
    }
}

/**
Link: https://leetcode-cn.com/problems/add-two-numbers/

给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字0之外，这两个数都不会以0开头。

示例1：
输入：l1 = [2, 4, 3], l2 = [5, 6, 4]
输出：[7, 0, 8]
解释：342 + 465 = 807.

示例2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例3：
输入：l1 = [9, 9, 9, 9, 9, 9, 9], l2 = [9, 9, 9, 9]
输出：[8, 9, 9, 9, 0, 0, 0, 1]

提示：
每个链表中的节点数在范围[1, 100]内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

*/