package sword.to.offer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LT37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (Objects.isNull(node)) {
                result += ",";
                continue;
            }
            q.add(node.left);
            q.add(node.right);
            result += (node.val + ",");
        }
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int len = arr.length;
        if (len == 0 || arr[0].equals("")) {
            return null;
        }
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx++]));
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (idx < len) {
            TreeNode node = q.poll();
            while (Objects.isNull(node)) {
                node = q.poll();
            }
            if (idx < len) {
                node.left = arr[idx].equals("") ? null : new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.left);
                ++idx;
            }
            if (idx < len) {
                node.right = arr[idx].equals("")  ? null : new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.right);
                ++idx;
            }
        }
        return root;
    }

    private static TreeNode build(Integer[] arr) {
        int len = arr.length;
        if (len == 0) {
            return null;
        }
        int idx = 0;
        TreeNode root = new TreeNode(arr[idx++]);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (idx < len) {
            TreeNode node = q.poll();
            while (Objects.isNull(node)) {
                node = q.poll();
            }
            if (idx < len) {
                node.left = Objects.isNull(arr[idx]) ? null : new TreeNode(arr[idx]);
                q.add(node.left);
                ++idx;
            }
            if (idx < len) {
                node.right = Objects.isNull(arr[idx]) ? null : new TreeNode(arr[idx]);
                q.add(node.right);
                ++idx;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = build(new Integer[]{1, 2, 3, null, null, 4, 5});

        LT37 lt37 = new LT37();
        root.show();

        String str = lt37.serialize(root);
        System.out.println(str);

        root = lt37.deserialize(str);
        if (Objects.nonNull(root)) {
            root.show();
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public void show() {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(this);
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                if (Objects.isNull(t)) {
                    System.out.print("null ");
                    continue;
                }
                q.add(t.left);
                q.add(t.right);
                System.out.print(t.val + " ");
            }
            System.out.println();
        }

     }

}


/**
Link: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/

请实现两个函数，分别用来序列化和反序列化二叉树。
你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列/反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
提示：输入输出格式与LeetCode目前使用的方式一致，详情请参阅LeetCode序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

示例：
输入：root = [1, 2, 3, null, null, 4, 5]
输出：[1, 2, 3, null, null, 4, 5]

*/