package In.House.Q515;

import java.util.*;

public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (true) {
            Queue<TreeNode> tmp = new ArrayDeque();
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                max = cur.val > max ? cur.val : max;
                if (Objects.nonNull(cur.left)) {
                    tmp.add(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    tmp.add(cur.right);
                }
            }
            result.add(max);
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
        slt.largestValues(toTree(new Integer[] {2, 1, 3}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [2, 3]
        slt.largestValues(toTree(new Integer[] {1, 2, 3, 4, null, 5, 6, null, null, 7}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [1, 3, 6, 7]
        slt.largestValues(toTree(new Integer[] {1, 3, 2, 5, 3, null, 9}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [1, 3, 9]
        slt.largestValues(toTree(new Integer[] {1, 2, 3}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println(); // [1, 3]
    }

}


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