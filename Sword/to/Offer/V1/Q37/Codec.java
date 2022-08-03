package Sword.to.Offer.V1.Q37;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (Objects.isNull(node)) {
                result += ",";
                continue;
            }
            q.add(node.left);
            q.add(node.right);
            result += (node.val + ",");
        }
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int len = arr.length;
        if (len == 0 || arr[0].equals("")) {
            return null;
        }
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (idx < len) {
            TreeNode node = q.poll();
            while (Objects.isNull(node)) {
                node = q.poll();
            }
            if (idx < len) {
                node.left = arr[idx].equals("") ? null : new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.left);
                ++idx;
            }
            if (idx < len) {
                node.right = arr[idx].equals("")  ? null : new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.right);
                ++idx;
            }
        }
        return root;
    }

    private static TreeNode build(Integer[] arr) {
        int len = arr.length;
        if (len == 0) {
            return null;
        }
        int idx = 0;
        TreeNode root = new TreeNode(arr[idx++]);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (idx < len) {
            TreeNode node = q.poll();
            while (Objects.isNull(node)) {
                node = q.poll();
            }
            if (idx < len) {
                node.left = Objects.isNull(arr[idx]) ? null : new TreeNode(arr[idx]);
                q.add(node.left);
                ++idx;
            }
            if (idx < len) {
                node.right = Objects.isNull(arr[idx]) ? null : new TreeNode(arr[idx]);
                q.add(node.right);
                ++idx;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = build(new Integer[]{1, 2, 3, null, null, 4, 5});

        Codec codec = new Codec();
        root.show();

        String str = codec.serialize(root);
        System.out.println(str);

        root = codec.deserialize(str);
        if (Objects.nonNull(root)) {
            root.show();
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public void show() {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (Objects.isNull(t)) {
                System.out.print("null ");
                continue;
            }
            q.add(t.left);
            q.add(t.right);
            System.out.print(t.val + " ");
        }
        System.out.println();
    }

}