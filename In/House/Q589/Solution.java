package In.House.Q589;

import java.util.*;

public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Deque<Node> stack = new LinkedList<>() {{ add(root); }};
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);
            if (Objects.nonNull(cur.children)) {
                int len = cur.children.size();
                for (int i = len - 1; i > -1 ; --i) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
Ques: N叉树的前序遍历
Link: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/

给定一个n叉树的根节点root，返回其节点值的前序遍历。
n叉树在输入中按层序遍历进行序列化表示，每组子节点由空值null分隔（请参见示例）。

示例1(图1.png)：
输入：root = [1, null, 3, 2, 4, null, 5, 6]
输出：[1, 3, 5, 6, 2, 4]

示例2(图2.png)：
输入：root = [1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14]
输出：[1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]

提示：
节点总数在范围 [0, 10^4]内
0 <= Node.val <= 10^4
n叉树的高度小于或等于1000

进阶：递归法很简单，你可以使用迭代法完成此题吗?
*/