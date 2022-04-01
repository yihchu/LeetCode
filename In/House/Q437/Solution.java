package In.House.Q437;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, targetSum, true);
    }

    private int pathSum(TreeNode root, int target, int left, boolean flag) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int result = 0;
        if (left == root.val) {
            result += 1;
        }
        if (Objects.nonNull(root.left)) {
            result += pathSum(root.left, target, left - root.val, flag);
            if (flag) result += pathSum(root.left, target, target, false);
        }
        if (Objects.nonNull(root.right)) {
            result += pathSum(root.right, target, left - root.val, flag);
            if (flag) result += pathSum(root.right, target, target, false);
        }
        return result;
    }


    private static void test(Integer[] array, int target) {
        int len = array.length;
        if (len == 0) {
            System.out.println(new Solution().pathSum(null, target)); // 0
            return;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> q = new LinkedList<>() {{add(root);}};
        int idx = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (idx < len) {
                Integer v = array[idx ++];
                if (Objects.nonNull(v)) {
                    node.left = new TreeNode(v);
                    q.add(node.left);
                }
            }
            if (idx < len) {
                Integer v = array[idx ++];
                if (Objects.nonNull(v)) {
                    node.right = new TreeNode(v);
                    q.add(node.right);
                }
            }
        }
        System.out.println(new Solution().pathSum(root, target));
    }

    public static void main(String[] args) {
        test(new Integer[0], 1);
        test(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}, 8); // 3
        test(new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}, 22); // 3
        test(new Integer[] {1, null, 2, null, 3, null, 4, null, 5}, 3); // 2
        test(new Integer[] {1, -2, -3, 1, 3, -2, null, -1}, -1); // 4
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

