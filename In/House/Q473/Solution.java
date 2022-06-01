package In.House.Q473;

import java.util.Arrays;

public class Solution {

    public boolean makesquare(int[] matchsticks) {
        int perimeter = Arrays.stream(matchsticks).sum();
        if (perimeter % 4 != 0) {
            return false;
        }
        matchsticks = Arrays.stream(matchsticks).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, perimeter / 4);
    }

    private boolean dfs(int idx, int[] matchsticks, int[] edges, int len) {
        if (idx == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            edges[i] += matchsticks[idx];
            if (edges[i] <= len && dfs(idx + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[idx];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.makesquare(new int[] {1, 1, 2, 2, 2})); // true
        System.out.println(slt.makesquare(new int[] {3, 3, 3, 3, 4})); // false
    }

}
