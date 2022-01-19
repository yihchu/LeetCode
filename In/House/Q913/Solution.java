package In.House.Q913;

import java.util.Arrays;

public class Solution {

    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int DRAW = 0;
    int n, threshold;
    int[][] graph;
    int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.threshold = n * 2;
        this.graph = graph;
        this.dp = new int[n][n][n * 2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0;j < n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    private int getResult(int mouse, int cat, int turns) {
        if (turns == threshold) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                dp[mouse][cat][turns] = MOUSE_WIN;
            } else if (mouse == cat) {
                dp[mouse][cat][turns] = CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    private void getNextResult(int mouse, int cat, int turns) {
        int curMove = turns % 2 == 0 ? mouse : cat;
        int defaultResult = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int result = defaultResult;
        int[] nextNodes = graph[curMove];
        for (int next: nextNodes) {
            if (curMove == cat && next == 0) {
                continue;
            }
            int nextMouse = curMove == mouse ? next : mouse;
            int nextCat = curMove == cat ? next : cat;
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            if (nextResult != defaultResult) {
                result = nextResult;
                if (result != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.catMouseGame(new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}}));
        System.out.println(slt.catMouseGame(new int[][]{{1, 3}, {0}, {3}, {0, 2}}));
    }

}

/**
Ques: 猫和老鼠
Link: https://leetcode-cn.com/problems/cat-and-mouse/

两位玩家分别扮演猫和老鼠，在一张无向图上进行游戏，两人轮流行动。
图的形式是：graph[a]是一个列表，由满足ab是图中的一条边的所有节点b组成。
老鼠从节点1开始，第一个出发；猫从节点2开始，第二个出发。在节点0处有一个洞。
在每个玩家的行动中，他们必须沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点1，那么它必须移动到graph[1]中的任一节点。
此外，猫无法移动到洞中（节点0）。
然后，游戏在出现以下三种情形之一时结束：
如果猫和老鼠出现在同一个节点，猫获胜。
如果老鼠到达洞中，老鼠获胜。
如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
给你一张图graph，并假设两位玩家都都以最佳状态参与游戏：
如果老鼠获胜，则返回1；
如果猫获胜，则返回2；
如果平局，则返回0。

示例1(图1.jpg)：
输入：graph = [[2, 5], [3], [0, 4, 5], [1, 4, 5], [2, 3], [0, 2, 3]]
输出：0

示例2(图2.jpg)：
输入：graph = [[1, 3], [0], [3], [0, 2]]
输出：1

提示：
3 <= graph.length <= 50
1<= graph[i].length < graph.length
0 <= graph[i][j] < graph.length
graph[i][j] != i
graph[i]互不相同
猫和老鼠在游戏中总是移动

*/
