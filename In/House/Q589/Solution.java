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

