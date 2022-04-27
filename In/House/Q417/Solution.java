package In.House.Q417;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int[][] dirs = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];
        for (int i = 0; i < m; ++i){
            dfs(heights, canReachPacific, i, 0);
            dfs(heights, canReachAtlantic, i, n - 1);
        }
        for (int i = 0; i < n; ++i){
            dfs(heights, canReachPacific,0, i);
            dfs(heights, canReachAtlantic,m - 1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        canReach[i][j] = true;
        for (int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= heights.length || y < 0 || y >= heights[0].length || heights[x][y] < heights[i][j] || canReach[x][y]) {
                continue;
            }
            dfs(heights, canReach, x, y);
        }
    }

    private static void print(List<List<Integer>> lists) {
        for (List<Integer> list: lists) {
            for (int a: list) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        print(slt.pacificAtlantic(new int[][]{
//                {1, 2, 2, 3, 5},
//                {3, 2, 3, 4, 4},
//                {2, 4, 5, 3, 1},
//                {6, 7, 1, 4, 5},
//                {5, 1, 1, 2, 4}
//        })); // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
//        System.out.println();
//
//        print(slt.pacificAtlantic(new int[][]{
//                {2, 1},
//                {1, 2}
//        })); // [[0, 0], [0, 1], [1, 0], [1, 1]]
//        System.out.println();

        print(slt.pacificAtlantic(new int[][]{
                {3, 3, 3, 3, 3, 3},
                {3, 0, 3, 3, 0, 3},
                {3, 3, 3, 3, 3, 3}
        }));
        System.out.println();
    }

}
