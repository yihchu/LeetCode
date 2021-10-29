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

/**
 Link: https://leetcode-cn.com/problems/chuan-di-xin-xi/
 小朋友A在和ta的小伙伴们玩传信息游戏，游戏规则如下：
 有n名玩家，所有玩家编号分别为0 ～ n - 1，其中小朋友A的编号为0。
 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如A可以向B传信息，但B不能向A传信息）。
 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人。
 给定总玩家数n，以及按[玩家编号,对应可传递玩家编号]关系组成的二维数组relation。返回信息从小A(编号0)经过k轮传递到编号为n-1的小伙伴处的方案数；若不能到达，返回0。
 示例1：
 输入：n = 5, relation = [[0, 2], [2, 1], [3, 4], [2, 3], [1, 4], [2, 0], [0, 4]], k = 3
 输出：3
 解释：信息从小A编号0处开始，经3轮传递，到达编号4。共有3种方案，分别是0->2->0->4，0->2->1->4，0->2->3->4。
 示例2：
 输入：n = 3, relation = [[0, 2], [2, 1]], k = 2
 输出：0
 解释：信息不能从小A处经过2轮传递到编号2
 限制：
 2 <= n <= 10
 1 <= k <= 5
 1 <= relation.length <= 90, 且 relation[i].length == 2
 0 <= relation[i][0], relation[i][1] < n 且 relation[i][0] != relation[i][1]
 */
