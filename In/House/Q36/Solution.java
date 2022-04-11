package In.House.Q36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>(); // check row
        Map<Integer, Set<Character>> columnMap = new HashMap<>(); // check column
        Map<Integer, Set<Character>> subMap = new HashMap<>(); // check sub 3x3

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!addAndcheck(rowMap, i, c)
                        || !addAndcheck(columnMap, j, c)
                        || !addAndcheck(subMap, i / 3 * 3 + j / 3, c)
                ) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean addAndcheck(Map<Integer, Set<Character>> map, int idx, char element) {
        if (map.containsKey(idx)) { // check column
            Set<Character> s = map.get(idx);
            if (s.contains(element)) {
                return false;
            }
            s.add(element);
        } else {
            Set<Character> s = new HashSet<>();
            s.add(element);
            map.put(idx, s);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();

        System.out.println(slt.isValidSudoku(new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // true

        System.out.println(slt.isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // false

    }

}


