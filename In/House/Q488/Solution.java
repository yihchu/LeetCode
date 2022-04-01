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

