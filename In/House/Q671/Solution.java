package In.House.Q671;


import java.util.Objects;

public class Solution {

    public int findSecondMinimumValue(TreeNode root) {
        long result = findSecondMinimumValue(root, root.val);
        return result == (long)Integer.MAX_VALUE + 1 ? -1 : (int)result;
    }

    private long findSecondMinimumValue(TreeNode root, int min) {
        if (Objects.isNull(root.left)) {
            return root.val > min ? root.val : (long)Integer.MAX_VALUE + 1;
        }
        long l, r;
        if (root.left.val == root.right.val) {
            l = findSecondMinimumValue(root.left, min);
            r = findSecondMinimumValue(root.right, min);
        } else if (root.val == root.left.val) {
            l = findSecondMinimumValue(root.left, min);
            r = root.right.val;
        } else {
            l = root.left.val;
            r = findSecondMinimumValue(root.right, min);
        }
        l = l == min ? (long)Integer.MAX_VALUE + 1 : l;
        r = r == min ? (long)Integer.MAX_VALUE + 1 : r;
        return l < r ? l : r;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        // test1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(slt.findSecondMinimumValue(root1)); // 5
        // test2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(slt.findSecondMinimumValue(root2)); // -1
        // test3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(2);
        root3.right.right = new TreeNode(2);
        System.out.println(slt.findSecondMinimumValue(root3)); // 2
        // test4 [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        // test5
        System.out.println(slt.findSecondMinimumValue(new TreeNode(2))); // -1
        // test6
        TreeNode root6 = new TreeNode(2);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(2147483647);
        System.out.println(slt.findSecondMinimumValue(root6));
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


