package In.House.Q427;

public class Solution {

    public Node construct(int[][] grid) {
        int len = grid.length;
        return dfs(grid, 0, 0, len, len);
    }

    private Node dfs(int[][] grid, int top, int left, int bottom, int right) {
        boolean flag = true;
        for (int i = top; i < bottom; ++i) {
            for (int j = left; j < right; ++j) {
                if (grid[i][j] == grid[top][left]) {
                    continue;
                }
                flag = false;
                break;
            }
            if (!flag) {
                break;
            }
        }
        if (flag) {
            return new Node(grid[top][left] == 1, true);
        }
        int midRow = (top + bottom) / 2, midCol = (left + right) / 2;
        return new Node(true, false
                , dfs(grid, top, left, midRow, midCol)
                , dfs(grid, top, midCol, midRow, right)
                , dfs(grid, midRow, left, bottom, midCol)
                , dfs(grid, midRow, midCol, bottom, right));
    }


    public static void main(String[] args) {
        Solution slt = new Solution();

    }

}
