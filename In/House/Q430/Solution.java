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

/**
Ques: 扁平化多级双向链表
Link: https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/

多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

示例1：
输入：head = [1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12]
输出：[1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6]
解释：
输入的多级列表如图1.png所示。
扁平化后的链表如图2.png所示。

示例2：
输入：head = [1, 2, null, 3]
输出：[1, 3, 2]
解释：
输入的多级列表如下图所示：
1---2---NULL
|
3---NULL

示例3：
输入：head = []
输出：[]

如何表示测试用例中的多级链表？
以示例1为例：
1---2---3---4---5---6--NULL
        |
        7---8---9---10--NULL
            |
            11--12--NULL
序列化其中的每一级之后：
[1, 2, 3, 4, 5, 6, null]
[7, 8, 9, 10, null]
[11, 12, null]
为了将每一级都序列化到一起，我们需要每一级中添加值为null的元素，以表示没有节点连接到上一级的上级节点。
[1, 2, 3, 4, 5, 6, null]
[null, null, 7, 8, 9, 10, null]
[null, 11, 12, null]
合并所有序列化结果，并去除末尾的null。
[1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10, null, null, 11, 12]

提示：
节点数目不超过1000
1 <= Node.val <= 10^5

*/
