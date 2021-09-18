import java.util.*;

public class LT743 {

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
        LT743 lt743 = new LT743();
        System.out.println(lt743.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2)); // 2
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1)); // 1
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2)); // -1
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1)); // 2
        System.out.println(lt743.networkDelayTime(new int [][]{{1, 2, 1}, {2, 1, 3}}, 2, 2)); // 3
        System.out.println(lt743.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 1}}, 3, 2)); // -1
    }

}


/**
Link: https://leetcode-cn.com/problems/network-delay-time/

有n个网络节点，标记为1到n。
给你一个列表times，表示信号经过有向边的传递时间。times[i] = (u[i], v[i], w[i])，其中u[i]是源节点，v[i]是目标节点， w[i]是一个信号从源节点传递到目标节点的时间。
现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。

示例1：
输入：times = [[2, 1, 1], [2, 3, 1], [3, 4, 1]], n = 4, k = 2
输出：2

示例2：
输入：times = [[1, 2, 1]], n = 2, k = 1
输出：1

示例3：
输入：times = [[1, 2, 1]], n = 2, k = 2
输出：-1

提示：
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= u[i], v[i] <= n
u[i] != v[i]
0 <= w[i] <= 100
所有(u[i], v[i])对都互不相同（即，不含重复边）

*/