package In.House.Q21;

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
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, tail = null;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            int val = list1.val;
            if (list1.val > list2.val) {
                val = list2.val;
                list2 = list2.next;
            } else {
                list1 = list1.next;
            }
            if (Objects.isNull(head)) {
                head = tail = new ListNode(val);
                continue;
            }
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        head = copy(head, tail, list1);
        head = copy(head, tail, list2);
        return head;
    }

    private ListNode copy(ListNode tHead, ListNode tTail, ListNode origin) {
        while (Objects.nonNull(origin)) {
            if (Objects.isNull(tHead)) {
                tHead = tTail = new ListNode(origin.val);
            } else {
                tTail.next = new ListNode(origin.val);
                tTail = tTail.next;
            }
            origin = origin.next;
        }
        return tHead;
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
        System.out.print(">>>>> ");
        while (Objects.nonNull(root)) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.mergeTwoLists(toList(new int[] {1, 2, 4}), toList(new int[] {1, 3, 4}))); // [1, 1, 2, 3, 4, 4]
        print(slt.mergeTwoLists(toList(new int[] { }), toList(new int[] { }))); // [ ]
        print(slt.mergeTwoLists(toList(new int[] { }), toList(new int[] {0}))); // [0]
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

