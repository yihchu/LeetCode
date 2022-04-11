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

