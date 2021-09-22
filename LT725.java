import common.ListNode;

import java.util.Objects;

public class LT725 {

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
        LT725 lt725 = new LT725();
        lt725.print(lt725.splitListToParts(lt725.toList(new int[] {1, 2, 3}), 5));
        lt725.print(lt725.splitListToParts(lt725.toList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3));
    }

}

/**
Link: https://leetcode-cn.com/problems/split-linked-list-in-parts/

给你一个头结点为head的单链表和一个整数k，请你设计一个算法将链表分隔为k个连续的部分。
每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过1。这可能会导致有些部分为null。
这k个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
返回一个由上述k部分组成的数组。

示例1：
输入：head = [1, 2, 3], k = 5
输出：[[1], [2], [3], [], []]
解释：
第一个元素output[0]为output[0].val = 1 ，output[0].next = null。
最后一个元素output[4]为null，但它作为ListNode的字符串表示是[]。

示例2：
输入：head = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
输出：[[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
解释：
输入被分成了几个连续的部分，并且每部分的长度相差不超过1。前面部分的长度大于等于后面部分的长度。

提示：
链表中节点的数目在范围[0, 1000]
0 <= Node.val <= 1000
1 <= k <= 50

*/