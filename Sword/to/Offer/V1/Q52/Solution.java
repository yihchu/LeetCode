package Sword.to.Offer.V1.Q52;

import java.util.Objects;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode h1 = headA, h2 = headB;
        while (Objects.nonNull(h1)) {
            ++l1;
            h1 = h1.next;
        }
        while (Objects.nonNull(h2)) {
            ++l2;
            h2 = h2.next;
        }
        h1 = headA;
        h2 = headB;
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; ++i) {
                h1 = h1.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; ++i) {
                h2 = h2.next;
            }
        }
        while (Objects.nonNull(h1)) {
            if (h1 == h2) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        ListNode[] nodes1 = toList(8, new int[]{4, 1, 8, 4, 5}, 2, new int[]{5, 0, 1, 8, 4, 5}, 3);
        ListNode result1 = slt.getIntersectionNode(nodes1[0], nodes1[1]);
        System.out.println(Objects.isNull(result1) ? "null" : result1.val);

        ListNode[] nodes2 = toList(2, new int[]{0, 9, 1, 2, 4}, 3, new int[]{3, 2, 4}, 1);
        ListNode result2 = slt.getIntersectionNode(nodes2[0], nodes2[1]);
        System.out.println(Objects.isNull(result2) ? "null" : result2.val);

        ListNode[] nodes3 = toList(0, new int[]{2, 6, 4}, 3, new int[]{1, 5}, 2);
        ListNode result3 = slt.getIntersectionNode(nodes3[0], nodes3[1]);
        System.out.println(Objects.isNull(result3) ? "null" : result3.val);
    }

    private static ListNode[] toList(int intersectVal, int[] arr1, int stepA, int[] arr2, int stepB) {
        ListNode[] nodes = new ListNode[2];
        int len1 = arr1.length, len2 = arr2.length;
        if (len1 == 0 && len2 == 0) {
            return nodes;
        }
        ListNode head1 = null, tail1 = null, head2 = null, tail2 = null;
        if (len1 > 0) {
            int limit = intersectVal == 0 ? len1 : (stepA <= len1 ? stepA : len1);
            for (int i = 0; i < limit; ++i) {
                ListNode tmp = new ListNode(arr1[i]);
                if (Objects.isNull(head1)) {
                    head1 = tail1 = tmp;
                } else {
                    tail1.next = tmp;
                    tail1 = tmp;
                }
            }
        }
        if (len2 > 0) {
            int limit = intersectVal == 0 ? len2 : (stepB <= len2 ? stepB : len2);
            for (int i = 0; i < limit; ++i) {
                ListNode tmp = new ListNode(arr2[i]);
                if (Objects.isNull(head2)) {
                    head2 = tail2 = tmp;
                } else {
                    tail2.next = tmp;
                    tail2 = tmp;
                }
            }
        }
        if (intersectVal != 0) {
            ListNode head = null, tail = null;
            for (int i = stepA; i < len1; ++i) {
                ListNode tmp = new ListNode(arr1[i]);
                if (Objects.isNull(head)) {
                    head = tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
            }
            if (Objects.nonNull(tail1)) {
                tail1.next = head;
            } else {
                head1 = head;
            }
            if (Objects.nonNull(tail2)) {
                tail2.next = head;
            } else {
                head2 = head;
            }
        }
        nodes[0] = head1;
        nodes[1] = head2;
        return nodes;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
