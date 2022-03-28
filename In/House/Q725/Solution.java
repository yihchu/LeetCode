package In.House.Q725;

import java.util.Objects;

public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode p = head;
        int len = 0;
        while (Objects.nonNull(p)) {
            ++len;
            p = p.next;
        }
        p = head;
        int idx = 0;
        if (len < k) {
            while (Objects.nonNull(p)) {
                result[idx] = p;
                p = p.next;
                result[idx ++].next = null;
            }
            return result;
        }
        int size = len / k, left = len % k;
        while (Objects.nonNull(p)) {
            ListNode t = null;
            for (int i = 0; i < size; ++i) {
                if (Objects.isNull(result[idx])) {
                    result[idx] = t = new ListNode(p.val);
                } else {
                    t.next = new ListNode(p.val);
                    t = t.next;
                }
                p = p.next;
            }
            if (left > 0) {
                t.next = new ListNode(p.val);
                p = p.next;
                --left;
            }
            ++ idx;
        }
        return result;
    }

    private ListNode toList(int[] array) {
        ListNode head = null, tail = null;
        for (int n: array) {
            if (Objects.isNull(head)) {
                head = tail = new ListNode(n);
            } else {
                tail.next = new ListNode(n);
                tail = tail.next;
            }
        }
        return head;
    }

    private void print(ListNode[] nodes) {
        System.out.println(">>>>>>>>>>");
        for (ListNode node: nodes) {
            if (Objects.isNull(node)) {
                System.out.println("null");
                continue;
            }
            while (Objects.nonNull(node)) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
        System.out.println("<<<<<<<<<<");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.print(slt.splitListToParts(slt.toList(new int[] {1, 2, 3}), 5));
        slt.print(slt.splitListToParts(slt.toList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
