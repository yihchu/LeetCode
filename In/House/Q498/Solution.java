package In.House.Q498;

import java.util.Arrays;

/**
 * 哇，要注意方向！！！
 */
public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int idx = 0, limit = m + n;
        for (int k = 0; k < limit; k += 2) {
            int t = k, top = n - 1;
            for (int j = 0; j < n; ++j) {
                if (t >= m) {
                    --t;
                    continue;
                }
                if (t < 0) {
                    top = j;
                    break;
                }
                result[idx ++] = mat[t][j];
                if (j < n - 1) {
                    --t;
                }
            }
            ++t;
            for (int j = top; j > -1; --j) {
                if (t >= m) {
                    break;
                }
                result[idx ++] = mat[t ++][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}})).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}})).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.findDiagonalOrder(new int[][]{{1, 2, 3}})).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.findDiagonalOrder(new int[][]{{1}, {2}, {3}})).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
