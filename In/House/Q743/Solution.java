package In.House.Q743;

import java.util.*;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

    public static void main(String[] args) {
        Solution lt743 = new Solution();
        System.out.println(lt743.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2)); // 2
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1)); // 1
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2)); // -1
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1)); // 2
        System.out.println(lt743.networkDelayTime(new int [][]{{1, 2, 1}, {2, 1, 3}}, 2, 2)); // 3
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 1}}, 3, 2)); // -1
    }

}

