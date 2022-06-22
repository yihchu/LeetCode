package In.House.Q513;

import java.util.ArrayDeque;
import java.util.LinkedList;
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
class Solution {

    public int findBottomLeftValue(TreeNode root) {
        int result = -1;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (true) {
            Queue<TreeNode> tmp = new ArrayDeque();
            boolean flag = false;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (!flag) {
                    result = cur.val;
                    flag = true;
                }
                if (Objects.nonNull(cur.left)) {
                    tmp.add(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    tmp.add(cur.right);
                }
            }
            if (tmp.isEmpty()) {
                break;
            }
            queue = tmp;
        }
        return result;
    }

    private static TreeNode toTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        for (int i = 1; i < array.length; ) {
            TreeNode current = queue.poll();
            if (Objects.nonNull(array[i])) {
                TreeNode tmp = new TreeNode(array[i]);
                current.left = tmp;
                queue.add(tmp);
            } else {
                current.left = null;
            }
            ++i;
            if (i >= array.length) {
                continue;
            }
            if (Objects.nonNull(array[i])) {
                TreeNode tmp = new TreeNode(array[i]);
                current.right = tmp;
                queue.add(tmp);
            } else {
                current.right = null;
            }
            ++i;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findBottomLeftValue(toTree(new Integer[] {2, 1, 3}))); // 1
        System.out.println(slt.findBottomLeftValue(toTree(new Integer[] {1, 2, 3, 4, null, 5, 6, null, null, 7}))); // 7

    }

}