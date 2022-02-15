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


/**
Ques: 矩阵中的幸运数
Link: https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/

给你一个m * n的矩阵，矩阵中的数字各不相同。请你按任意顺序返回矩阵中的所有幸运数。
幸运数是指矩阵中满足同时下列两个条件的元素：
在同一行的所有元素中最小
在同一列的所有元素中最大

示例1：
输入：matrix = [[3, 7, 8], [9, 11, 13], [15, 16, 17]]
输出：[15]
解释：15是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例2：
输入：matrix = [[1, 10, 4, 2], [9, 3, 8, 7], [15, 16, 17, 12]]
输出：[12]
解释：12是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例3：
输入：matrix = [[7, 8], [1, 2]]
输出：[7]

提示：
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5
矩阵中的所有元素都是不同的

*/
