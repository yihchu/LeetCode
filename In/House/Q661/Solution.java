package In.House.Q661;

public class Solution {

    private int[][] directions = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    public int[][] imageSmoother(int[][] img) {
        int row = img.length, col = img[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int sum = 0, count = 0;
                for (int k = 0; k < 9; ++k) {
                    int c = i + directions[k][0], r = j + directions[k][1];
                    if (c < 0 || c >= row || r < 0 || r >= col) {
                        continue;
                    }
                    ++ count;
                    sum += img[c][r];
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.imageSmoother(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }));
        print(slt.imageSmoother(new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        }));
    }

    private static void print(int[][] arrs) {
        int row = arrs.length, col = arrs[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                System.out.print(arrs[i][j] + " ");
            }
            System.out.println();
        }
    }

}