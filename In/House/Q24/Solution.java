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

