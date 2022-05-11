package In.House.Q449;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append(root.val + 1);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            handleNode(node.left, builder, queue);
            handleNode(node.right, builder, queue);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        int[] array = Arrays.stream(data.split(",")).mapToInt(s -> Integer.valueOf(s) - 1).toArray();
        int idx = 0;
        TreeNode root = new TreeNode(array[idx ++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = array[idx] < 0 ? null : new TreeNode(array[idx]);
            ++idx;
            node.right = array[idx] < 0 ? null : new TreeNode(array[idx]);
            ++idx;
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
        }
        return root;
    }

    private void handleNode(TreeNode node, StringBuilder builder, Queue<TreeNode> queue) {
        builder.append(",");
        if (Objects.isNull(node)) {
            builder.append(0);
            return;
        }
        queue.add(node);
        builder.append(node.val + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        Codec codec = new Codec();
        String str = codec.serialize(root);
        System.out.println(str);
        TreeNode node = codec.deserialize(str);
        System.out.println(node);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;