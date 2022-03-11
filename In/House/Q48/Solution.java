package In.House.Q48;

public class Solution {

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; ++i) {
            for (int j = 0; j < (len + 1) / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }

    private void print(int[][] arrs) {
        int row = arrs.length, col = arrs[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(arrs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[][] arrs1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        slt.rotate(arrs1);
        slt.print(arrs1);

        int[][] arrs2 = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        slt.rotate(arrs2);
        slt.print(arrs2);
    }

}

/**
Ques: 旋转图像
Link: https://leetcode-cn.com/problems/rotate-image/

给定一个n × n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例1(图1.jpeg)：
输入：matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
输出：[[7, 4, 1], [8, 5, 2], [9, 6, 3]]

示例2(图2.jpeg)：
输入：matrix = [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]
输出：[[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]

提示：
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

*/