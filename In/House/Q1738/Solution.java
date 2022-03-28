package In.House.Q1738;

import java.util.Arrays;

public class Solution {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] xors = new int[m * n];
        xors[0] = matrix[0][0];
        for (int j = 1; j < n; ++j) {
            xors[j] = xors[j - 1] ^ matrix[0][j];
        }
        for (int i = 1; i < m; ++i) {
            xors[i * n] = xors[(i - 1) * n] ^ matrix[i][0];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                xors[i * n + j] = xors[(i - 1) * n + j] ^ xors[i * n + j - 1] ^ xors[(i - 1) * n + j - 1] ^ matrix[i][j];
            }
        }
        Arrays.sort(xors);
        return xors[xors.length - k];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1)); // 7
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2)); // 5
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3)); // 4
        System.out.println(slt.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4)); // 0
    }

}
