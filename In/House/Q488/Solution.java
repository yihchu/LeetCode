package In.House.Q488;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private String delete(String board) {
        int len = board.length();
        for (int i = 0; i < len; ) {
            int j = i;
            while (j < len && board.charAt(i) == board.charAt(j)) {
                ++j;
            }
            if (j - i > 2) {
                return delete(board.substring(0, i) + board.substring(j));
            } else {
                i = j;
            }
        }
        return board;
    }

    private int dfs(String board, Map<Character, Integer> map) {
        board = delete(board);
        if (board.length() <= 0) {
            return 0;
        }
        int result = 6, need, len = board.length();
        for (int i = 0; i < len;) {
            int j = i;
            char c = board.charAt(i);
            while (j < len && c == board.charAt(j)) {
                ++j;
            }
            need = 3 - (j - i);
            if (map.getOrDefault(c, 0) >= need) {
                map.put(c, map.get(c) - need);
                result = Math.min(result, need + dfs(board.substring(0, i) + board.substring(j), map));
                map.put(c, map.get(c) + need);
            }
            i = j;
        }
        return result;
    }

    public int findMinStep(String board, String hand) {
        //
        Map<Character, Integer> map = new HashMap<>();
        int len = hand.length();
        for (int i = 0; i < len; ++i) {
            char c = hand.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = dfs(board, map);
        return result == 6 ? -1 : result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findMinStep("WRRBBW", "RB")); // -1
        System.out.println(slt.findMinStep("WWRRBBWW", "WRBRW")); // 2
        System.out.println(slt.findMinStep("G", "GGGGG")); // 2
        System.out.println(slt.findMinStep("RBYYBBRRB", "YRBGB")); // 3
        System.out.println(slt.findMinStep("RRWWRRW", "R")); // -1

        // According to my understand, the testcases below are not right.
        System.out.println(slt.findMinStep("RRWWRRW", "WB")); // 2
        System.out.println(slt.findMinStep("RRWWRRBBRR", "WB")); // 2
        System.out.println(slt.findMinStep("RRYGGYYRRYYGGYRR", "GGBBB")); // 5
    }

}

/**
Ques: 祖玛游戏
Link: https://leetcode-cn.com/problems/zuma-game/

你正在参与祖玛游戏的一个变种。
在这个祖玛游戏变体中，桌面上有一排彩球，每个球的颜色可能是：红色'R'、黄色'Y'、蓝色'B'、绿色'G' 或白色'W'。你的手中也有一些彩球。
你的目标是清空桌面上所有的球。每一回合：
从你手上的彩球中选出任意一颗，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
接着，如果有出现三个或者三个以上且颜色相同的球相连的话，就把它们移除掉。
如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
如果桌面上所有球都被移除，则认为你赢得本场游戏。
重复这个过程，直到你赢了游戏或者手中没有更多的球。
给你一个字符串board，表示桌面上最开始的那排球。另给你一个字符串hand，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的最少球数。如果不能移除桌上所有的球，返回-1。

示例1：
输入：board = "WRRBBW", hand = "RB"
输出：-1
解释：无法移除桌面上的所有球。可以得到的最好局面是：
- 插入一个'R'，使桌面变为WRRRBBW。WRRRBBW -> WBBW
- 插入一个'B'，使桌面变为WBBBW。WBBBW -> WW
桌面上还剩着球，没有其他球可以插入。

示例2：
输入：board = "WWRRBBWW", hand = "WRBRW"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'R'，使桌面变为WWRRRBBWW。WWRRRBBWW -> WWBBWW
- 插入一个'B'，使桌面变为WWBBBWW。WWBBBWW -> WWWW -> empty
只需从手中出2个球就可以清空桌面。

示例3：
输入：board = "G", hand = "GGGGG"
输出：2
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'G'，使桌面变为GG 。
- 插入一个'G'，使桌面变为GGG。GGG -> empty
只需从手中出2个球就可以清空桌面。

示例4：
输入：board = "RBYYBBRRB", hand = "YRBGB"
输出：3
解释：要想清空桌面上的球，可以按下述步骤：
- 插入一个'Y'，使桌面变为RBYYYBBRRB。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
- 插入一个'B'，使桌面变为BB。
- 插入一个'B'，使桌面变为BBB。BBB -> empty
只需从手中出3个球就可以清空桌面。

提示：
1 <= board.length <= 16
1 <= hand.length <= 5
board和hand由字符'R'、'Y'、'B'、'G'和'W'组成
桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球

*/