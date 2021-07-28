import java.util.Objects;

public class LT671 {

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
        LT671 lt671 = new LT671();
        // test1
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        System.out.println(lt671.findSecondMinimumValue(root1)); // 5
        // test2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        System.out.println(lt671.findSecondMinimumValue(root2)); // -1
        // test3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(2);
        root3.right.right = new TreeNode(2);
        System.out.println(lt671.findSecondMinimumValue(root3)); // 2
        // test4 [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        // test5
        System.out.println(lt671.findSecondMinimumValue(new TreeNode(2))); // -1
        // test6
        TreeNode root6 = new TreeNode(2);
        root6.left = new TreeNode(2);
        root6.right = new TreeNode(2147483647);
        System.out.println(lt671.findSecondMinimumValue(root6));
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

/*
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出-1。

示例 1：
输入：root = [2, 2, 5, null, null, 5, 7]
输出：5
解释：最小的值是2，第二小的值是5。

示例 2：
输入：root = [2, 2, 2]
输出：-1
解释：最小的值是2, 但是不存在第二小的值。

提示：
树中节点数目在范围[1, 25]内
1 <= Node.val <= 2^31 - 1
对于树中每个节点 root.val == min(root.left.val, root.right.val)
*/