package In.House.Q19;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tractor = new ListNode(-1);
        tractor.next = head;
        ListNode l1 = tractor, l2 = tractor;
        for (int i = 0; i < n; ++i) {
            l2 = l2.next;
        }
        while (Objects.nonNull(l2.next)) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l1.next = Objects.nonNull(l1.next.next) ? l1.next.next : null;
        return tractor.next;
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
        while (Objects.nonNull(root)) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.removeNthFromEnd(toList(new int[] {1, 2, 3, 4, 5}), 2)); // [1, 2, 3, 5]
        print(slt.removeNthFromEnd(toList(new int[] {1}), 1)); // []
        print(slt.removeNthFromEnd(toList(new int[] {1, 2}), 1)); // [1]
    }

}

