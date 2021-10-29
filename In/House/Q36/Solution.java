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

/**
Link: https://leetcode-cn.com/problems/valid-sudoku/

请你判断一个9x9的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字1-9在每一行只能出现一次。
数字1-9在每一列只能出现一次。
数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考1.png）
数独部分空格内已填入了数字，空白格用'.'表示。

注意：
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。

示例1：
输入：board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true

示例2：
输入：board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从5改为8以外，空格内其他数字均与示例1相同。但由于位于左上角的3x3宫内有两个8存在, 因此这个数独是无效的。

提示：
board.length == 9
board[i].length == 9
board[i][j]是一位数字或者'.'

*/
