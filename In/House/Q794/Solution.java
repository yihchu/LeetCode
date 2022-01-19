package In.House.Q794;

public class Solution {

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; ++i) {
            String str = board[i];
            for (int j = 0; j < 3; ++j) {
                char c = str.charAt(j);
                countX += (c == 'X' ? 1 : 0);
                countO += (c == 'O' ? 1 : 0);
            }
        }
        if (countX != countO && countX - countO != 1) {
            return false;
        }
        int[][] array = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        int line = 0;
        int[] firstLine = null;
        for (int[] idxes: array) {
            char c = checkLine(board, idxes);
            if (' ' == c) {
                continue;
            }
            if (c == 'X' && countX == countO) {
                return false;
            }
            if (c == 'O' && countX > countO) {
                return false;
            }
            ++line;
            if ((line == 2 && !hasIntersection(firstLine, idxes)) || line > 2) {
                return false;
            }
            firstLine = idxes;
        }
        return true;
    }

    private char checkLine(String[] board, int[] idxes) {
        char c = getChar(board, idxes[0]);
        if (c == ' ') {
            return c;
        }
        if (c == getChar(board, idxes[1]) && c == getChar(board, idxes[2])) {
            return c;
        }
        return ' ';
    }

    private char getChar(String[] board, int idx) {
        return board[idx / 3].charAt(idx % 3);
    }

    private boolean hasIntersection(int[] arr1, int[] arr2) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (arr1[i] == arr2[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.validTicTacToe(new String[] {"O  ", "   ", "   "})); // false
        System.out.println(slt.validTicTacToe(new String[] {"XOX", " X ", "   "})); // false
        System.out.println(slt.validTicTacToe(new String[] {"XXX", "   ", "OOO"})); // false
        System.out.println(slt.validTicTacToe(new String[] {"XOX", "O O", "XOX"})); // true
        System.out.println(slt.validTicTacToe(new String[] {"XXX", "OOX", "OOX"})); // true
        System.out.println(slt.validTicTacToe(new String[] {"XXX","   ","OOO"})); // false
        System.out.println(slt.validTicTacToe(new String[] {"XXX","XOO","OO "})); // false
        System.out.println(slt.validTicTacToe(new String[] {"OXX","XOX","OXO"})); // false
    }

}

/**
Ques: 有效的井字游戏
Link: https://leetcode-cn.com/problems/valid-tic-tac-toe-state/

用字符串数组作为井字游戏的游戏板board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回true。
该游戏板是一个3 x 3数组，由字符" "，"X"和"O"组成。字符" "代表一个空位。
以下是井字游戏的规则：
玩家轮流将字符放入空位（" "）中。
第一个玩家总是放字符“X”，且第二个玩家总是放字符“O”。
“X”和“O”只允许放置在空位中，不允许对已放有字符的位置进行填充。
当有3个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
当所有位置非空时，也算为游戏结束。
如果游戏结束，玩家不允许再放置字符。

示例1:
输入: board = ["O  ", "   ", "   "]
输出: false
解释: 第一个玩家总是放置“X”。

示例2:
输入: board = ["XOX", " X ", "   "]
输出: false
解释: 玩家应该是轮流放置的。

示例3:
输入: board = ["XXX", "   ", "OOO"]
输出: false

示例4:
输入: board = ["XOX", "O O", "XOX"]
输出: true

说明:
游戏板board是长度为3的字符串数组，其中每个字符串board[i]的长度为3。
board[i][j]是集合{" ", "X", "O"}中的一个字符。

*/