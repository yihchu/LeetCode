package In.House.Q138;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public Node copyRandomList(Node head) {
        Node h = null, t = null, cur = head;
        Map<Integer, Node> newMap = new HashMap<>();
        Map<Node, Integer> oldMap = new HashMap<>();
        Integer idx = 0;
        while (Objects.nonNull(cur)) {
            Node node = new Node(cur.val);
            newMap.put(idx, node);
            oldMap.put(cur, idx);
            ++idx;
            if (Objects.isNull(h)) {
                h = t = node;
            } else {
                t.next = node;
                t = node;
            }
            cur = cur.next;
        }
        cur = head;
        Node newCur = h;
        while (Objects.nonNull(cur)) {
            newCur.random = newMap.get(oldMap.get(cur.random));
            cur = cur.next;
            newCur = newCur.next;
        }
        return h;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        show(slt.copyRandomList(toList(new int[][]{{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}})));
        show(slt.copyRandomList(toList(new int[][]{{1, 1}, {2, 1}})));
        show(slt.copyRandomList(toList(new int[][]{{3, -1}, {3, 0}, {3, -1}})));
        show(slt.copyRandomList(toList(new int[][]{})));
    }

    private static Node toList(int[][] array) {
        int len = array.length;
        Node head = null, tail = null;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) {
            Node node = new Node(array[i][0]);
            if (Objects.isNull(head)) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            nodes[i] = node;
        }
        for (int i = 0; i < len; ++i) {
            nodes[i].random = array[i][1] > -1 ? nodes[array[i][1]] : null;
        }
        return head;
    }

    private static void show(Node head) {
        Node node = head;
        while (Objects.nonNull(node)) {
            System.out.print("[" + node.val + ", " + (Objects.isNull(node.random) ? -1 : node.random.val) + "] ");
            node = node.next;
        }
        System.out.println();
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

