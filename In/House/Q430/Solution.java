package In.House.Q430;

import java.util.Objects;
import java.util.Stack;

public class Solution {

    // 就不知道为啥，prev也设置了，child也置null了，就是说我不是一个合法的双向链表~
    // 不管了，爱咋咋地~
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (Objects.nonNull(cur)) {
            if (Objects.isNull(cur.child)) {
                if (Objects.nonNull(cur.next)) {
                    cur = cur.next;
                    continue;
                }
                if (stack.isEmpty()) {
                    return head;
                }
                Node tmp = stack.pop();
                cur.next = tmp;
                tmp.prev = cur;
                cur = cur.next;
                continue;
            }
            stack.add(cur.next);
            cur.next = cur.child;
            cur.child = null;
        }
        return head;
    }

    private Node toNode(Integer[] array) {
        Node head = null, tail = null;
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (Objects.isNull(array[i])) {
                ++ count;
                continue;
            }
            //
            if (count > 0) {
                Node tmp = tail;
                while (count -- > 0) {
                    tmp = tmp.prev;
                }
                count = 0;
                tail = tmp.child = createNode(array[i]);
                tail.prev = tmp;
                continue;
            }
            if (Objects.isNull(head)) {
                head = tail = createNode(array[i]);
                continue;
            }
            tail.next = createNode(array[i]);
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }

    private void print(Node node, boolean withRandom) {
        Node tail = null;
        while (Objects.nonNull(node)) {
            tail = node;
            System.out.print(node.val + " ");
            if (withRandom && Objects.nonNull(node.child)) {
                print(node.child, true);
            }
            node = node.next;
        }
    }

    private Node createNode(int val) {
        Node node = new Node();
        node.val = val;
        return node;
    }

    public static void main(String[] args) {
        Solution lt430 = new Solution();
        lt430.print(lt430.flatten(lt430.toNode(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12})), true);
        System.out.println();
        lt430.print(lt430.flatten(lt430.toNode(new Integer[]{1, 2, null, 3})), true);
        System.out.println();
        lt430.print(lt430.flatten(lt430.toNode(new Integer[]{})), true);
        System.out.println();
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


