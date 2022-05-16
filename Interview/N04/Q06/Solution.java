package Interview.N04.Q06;

import java.util.*;

public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (Objects.isNull(root) || Objects.isNull(p)) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        ListIterator<TreeNode> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (p.equals(iterator.next())) {
                return iterator.hasNext() ? iterator.next() : null;
            }
        }
        return null;
    }

    private void dfs(TreeNode node, List<TreeNode> list) {
        if (Objects.nonNull(node.left)) {
            dfs(node.left, list);
        }
        list.add(node);
        if (Objects.nonNull(node.right)) {
            dfs(node.right, list);
        }
    }

    private static TreeNode toTree(Integer[] array) {
        int len = array.length, idx = 0;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[idx ++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && idx < array.length) {
            TreeNode node = queue.poll();
            if (idx < array.length) {
                node.left = Objects.isNull(array[idx]) ? null : new TreeNode(array[idx]);
                queue.add(node.left);
                ++idx;
            }
            if (idx < array.length) {
                node.right = Objects.isNull(array[idx]) ? null : new TreeNode(array[idx]);
                queue.add(node.right);
                ++idx;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();

        TreeNode tree1 = toTree(new Integer[] {2, 1, 3});
        TreeNode result1 = slt.inorderSuccessor(tree1, tree1.left);
        System.out.println(Objects.isNull(result1) ? "null" : result1.val);

        TreeNode tree2 = toTree(new Integer[] {5, 3, 6, 2, 4, null, null, 1});
        TreeNode result2 = slt.inorderSuccessor(tree2, tree2.right);
        System.out.println(Objects.isNull(result2) ? "null" : result2.val);
    }

}
