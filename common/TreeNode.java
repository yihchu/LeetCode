package common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int x) { this.val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fromArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (Objects.isNull(node)) {
                continue;
            }
            if (idx < len) {
                node.left = array[idx] < 0 ? null : new TreeNode(array[idx]);
                q.add(node.left);
                ++idx;
            } else {
                break;
            }
            if (idx < len) {
                node.right = array[idx] < 0 ? null : new TreeNode(array[idx]);
                q.add(node.right);
                ++idx;
            } else {
                break;
            }
        }
        q.clear();
        return root;
    }

    public static int[] toArray(TreeNode root) {
        if (Objects.isNull(root)) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(Objects.isNull(node) ? -1 : node.val);
            if (Objects.nonNull(node.left)) {
                q.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                q.add(node.right);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}