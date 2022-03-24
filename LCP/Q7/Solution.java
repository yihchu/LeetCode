package LCP.Q7;

public class Solution {

    public int numWays(int n, int[][] relation, int k) {
        int[][] map = new int[n][n];
        for (int i = 0; i < relation.length; ++i) {
            map[relation[i][0]][relation[i][1]] = 1;
        }
        return findWays(0, map, k);
    }

    public int findWays(int start, int[][] map, int k) {
        int len = map.length;
        if (k == 1) {
            return map[start][len - 1] > 0 ? 1 : 0;
        }
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += (map[start][i] > 0 ? findWays(i, map, k - 1) : 0);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3));
        System.out.println(slt.numWays(3, new int[][]{{0, 2}, {2, 1}}, 2));
    }

}

