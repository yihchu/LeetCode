package In.House.Q240;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; ++i) {
            if (target < matrix[i][0]) {
                return false;
            }
            for (int j = 0; j < col; ++j) {
                if (target == matrix[i][j]) {
                    return true;
                } else if (target < matrix[i][j]) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(slt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(slt.searchMatrix(new int[][]{{-1, 3}}, 3));
    }

}

/**
Link: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

编写一个高效的算法来搜索m x n矩阵matrix中的一个目标值target。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

示例1(1.jpg)：
输入：matrix = [[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], target = 5
输出：true

示例2(2.jpg)：
输入：matrix = [[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], target = 20
输出：false

提示：
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-10^9 <= target <= 10^9

*/