package In.House.Q450;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
                return null;
            }
            if (Objects.isNull(root.right)) {
                return root.left;
            }
            if (Objects.isNull(root.left)) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (Objects.nonNull(successor.left)) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }

    private static TreeNode buildTree(Integer[] array) {
        int len = array.length, idx = 0;
        if (len == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(array[idx ++]);
        queue.add(root);
        while (idx < len) {
            TreeNode node = queue.poll();
            node.left = idx < len && Objects.nonNull(array[idx]) ? new TreeNode(array[idx]) : null;
            node.right = idx < len && Objects.nonNull(array[idx]) ? new TreeNode(array[idx]) : null;
            if (Objects.nonNull(node.left)) {
                queue.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        TreeNode tree1 = buildTree(new Integer[] {41, 22, 58, 15, 33, 50, null, 13, null, null, 37, 42, 53});
        //
    }

}
