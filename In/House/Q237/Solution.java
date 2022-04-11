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

