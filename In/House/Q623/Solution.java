package In.House.Q623;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if ((Objects.isNull(root.left) && Objects.isNull(root.right)) || depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            if (curDepth == depth - 1) {
                while (!queue.isEmpty()) {
                    TreeNode cur = queue.poll();
                    TreeNode tmpL = cur.left;
                    TreeNode tmpR = cur.right;
                    TreeNode tmpNL = new TreeNode(val);
                    TreeNode tmpNR = new TreeNode(val);
                    cur.left = tmpNL;
                    cur.right = tmpNR;
                    tmpNL.left = tmpL;
                    tmpNR.right = tmpR;
                }
                return root;
            }
            Queue<TreeNode> tmpQ = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (Objects.nonNull(cur.left)) {
                    tmpQ.add(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    tmpQ.add(cur.right);
                }
            }
            if (!tmpQ.isEmpty()) {
                queue = tmpQ;
                ++curDepth;
            }
        }
        return root;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (Objects.nonNull(cur.left)) {
                queue.add(cur.left);
            }
            if (Objects.nonNull(cur.right)) {
                queue.add(cur.right);
            }
            System.out.print(cur.val + " ");
        }
        System.out.println();
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
        print(slt.addOneRow(toTree(new Integer[] {4, 2, 6, 3, 1, 5}), 1, 2));
        print(slt.addOneRow(toTree(new Integer[] {4, 2, null, 3, 1}), 1, 3));
        print(slt.addOneRow(toTree(new Integer[] {4, 2, 6, 3, 1, 5}), 1, 3));
        print(slt.addOneRow(toTree(new Integer[] {4, 2, 6, 3, 1, 5}), 1, 1));
    }

}