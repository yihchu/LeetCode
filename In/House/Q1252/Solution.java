package In.House.Q1252;

public class Solution {

    public int oddCells(int m, int n, int[][] indices) {
        boolean[][] records = new boolean[m][n];
        int count = 0;
        for (int[] idx: indices) {
            for (int j = 0; j < n; ++j) {
                records[idx[0]][j] = !records[idx[0]][j];
                count += records[idx[0]][j] ? 1 : -1;
            }
            for (int i = 0; i < m; ++i) {
                records[i][idx[1]] = !records[i][idx[1]];
                count += records[i][idx[1]] ? 1 : -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.oddCells(2, 3, new int[][] {{0, 1}, {1, 1}})); // 6
        System.out.println(slt.oddCells(2, 2, new int[][] {{1, 1}, {0, 0}})); // 0
    }

}
