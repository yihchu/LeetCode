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
