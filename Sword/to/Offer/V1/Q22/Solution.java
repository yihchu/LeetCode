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