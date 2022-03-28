package In.House.Q1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] minOfRow = new int[row], maxOfCol = new int[col];
        Arrays.fill(minOfRow, Integer.MAX_VALUE);
        Arrays.fill(maxOfCol, Integer.MIN_VALUE);
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                minOfRow[i] = Math.min(minOfRow[i], matrix[i][j]);
                maxOfCol[j] = Math.max(maxOfCol[j], matrix[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (minOfRow[i] == maxOfCol[j]) {
                    result.add(minOfRow[i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}).forEach(a -> System.out.print(a + " ")); // [15]
        System.out.println();
        slt.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}).forEach(a -> System.out.print(a + " ")); // [12]
        System.out.println();
        slt.luckyNumbers(new int[][]{{7, 8}, {1, 2}}).forEach(a -> System.out.print(a + " ")); // [7]
        System.out.println();
    }

}

