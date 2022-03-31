package In.House.Q563;

import java.util.*;

public class Solution {

    public int findTilt(TreeNode root) {
        List<Integer> tilts = new ArrayList<>();
        doFindTilts(root, tilts);
        return tilts.stream().mapToInt(i -> i).sum();
    }

    private int doFindTilts(TreeNode root, List<Integer> tilts) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int tilt = Math.abs(doFindTilts(root.left, tilts) - doFindTilts(root.right, tilts));
        tilts.add(tilt);
        int sum = root.val + (Objects.isNull(root.left) ? 0 : root.left.val) + (Objects.isNull(root.right) ? 0 : root.right.val);
        root.val = sum;
        return sum;
    }

    private TreeNode toTree(Integer[] array) {
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
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {1, 2, 3}))); // 1
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {4, 2, 9, 3, 5, null, 7}))); // 15
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {21, 7, 14, 1, 1, 2, 2, 3, 3}))); // 9
        System.out.println(slt.findTilt(slt.toTree(new Integer[] {7, -7, 8, null, null, -3, 6, null, 9, null, null, null, -5}))); // 36
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
