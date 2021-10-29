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

/**
Link: https://leetcode-cn.com/problems/copy-list-with-random-pointer/

给你一个长度为n的链表，每个节点包含一个额外增加的随机指针random，该指针可以指向链表中的任何节点或空节点。
构造这个链表的深拷贝。深拷贝应该正好由n个全新节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的next指针和random指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
例如，如果原链表中有X和Y两个节点，其中X.random --> Y。那么在复制链表中对应的两个节点x和y，同样有x.random --> y。
返回复制链表的头节点。
用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
val：一个表示Node.val的整数。
random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
你的代码只接受原链表的头节点head作为传入参数。

示例1：
输入：head = [[7, null], [13, 0], [11, 4], [10, 2], [1, 0]]
输出：[[7, null], [13, 0], [11, 4], [10, 2], [1, 0]]

示例2：
输入：head = [[1, 1], [2, 1]]
输出：[[1, 1], [2, 1]]

示例3：
输入：head = [[3, null], [3, 0], [3, null]]
输出：[[3, null], [3, 0], [3, null]]

示例4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回null。

提示：
0 <= n <= 1000
-10000 <= Node.val <= 10000
Node.random为空（null）或指向链表中的节点。
*/