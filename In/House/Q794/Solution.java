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
