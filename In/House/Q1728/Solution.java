package In.House.Q1728;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 没办法，只能CV大法
 */
public class Solution {

    private final static int MOUSE_TURN = 0, CAT_TURN = 1;
    private final static int UNKNOWN = 0, MOUSE_WIN = 1, CAT_WIN = 2;
    private final static int MAX_MOVES = 1000;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int rows, cols;
    private String[] grid;
    private int catJump, mouseJump;
    private int food;
    private int[][][] degrees;
    private int[][][][] results;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        this.rows = grid.length;
        this.cols = grid[0].length();
        this.grid = grid;
        this.catJump = catJump;
        this.mouseJump = mouseJump;
        int startMouse = -1, startCat = -1;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                char c = grid[i].charAt(j);
                if (c == 'M') {
                    startMouse = getPos(i, j);
                } else if (c == 'C') {
                    startCat = getPos(i, j);
                } else if (c == 'F') {
                    this.food = getPos(i, j);
                }
            }
        }
        int total = this.rows * this.cols;
        this.degrees = new int[total][total][2];
        this.results = new int[total][total][2][2];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int mouse = 0; mouse < total; mouse++) {
            int mouseRow = mouse / this.cols, mouseCol = mouse % this.cols;
            if (grid[mouseRow].charAt(mouseCol) == '#') {
                continue;
            }
            for (int cat = 0; cat < total; cat++) {
                int catRow = cat / this.cols, catCol = cat % this.cols;
                if (grid[catRow].charAt(catCol) == '#') {
                    continue;
                }
                ++ this.degrees[mouse][cat][MOUSE_TURN];
                ++ this.degrees[mouse][cat][CAT_TURN];
                for (int[] dir : this.dirs) {
                    for (int row = mouseRow + dir[0], col = mouseCol + dir[1], jump = 1;
                         row >= 0 && row < this.rows && col >= 0 && col < this.cols && grid[row].charAt(col) != '#' && jump <= mouseJump;
                         row += dir[0], col += dir[1], jump++) {
                        int nextMouse = getPos(row, col), nextCat = getPos(catRow, catCol);
                        ++ this.degrees[nextMouse][nextCat][MOUSE_TURN];
                    }
                    for (int row = catRow + dir[0], col = catCol + dir[1], jump = 1;
                         row >= 0 && row < this.rows && col >= 0 && col < this.cols && grid[row].charAt(col) != '#' && jump <= catJump;
                         row += dir[0], col += dir[1], jump++) {
                        int nextMouse = getPos(mouseRow, mouseCol), nextCat = getPos(row, col);
                        ++ this.degrees[nextMouse][nextCat][CAT_TURN];
                    }
                }
            }
        }
        for (int pos = 0; pos < total; pos++) {
            int row = pos / this.cols, col = pos % this.cols;
            if (grid[row].charAt(col) == '#') {
                continue;
            }
            this.results[pos][pos][MOUSE_TURN][0] = CAT_WIN;
            this.results[pos][pos][MOUSE_TURN][1] = 0;
            this.results[pos][pos][CAT_TURN][0] = CAT_WIN;
            this.results[pos][pos][CAT_TURN][1] = 0;
            queue.offer(new int[]{pos, pos, MOUSE_TURN});
            queue.offer(new int[]{pos, pos, CAT_TURN});
        }
        for (int mouse = 0; mouse < total; mouse++) {
            int mouseRow = mouse / this.cols, mouseCol = mouse % this.cols;
            if (grid[mouseRow].charAt(mouseCol) == '#' || mouse == this.food) {
                continue;
            }
            this.results[mouse][this.food][MOUSE_TURN][0] = CAT_WIN;
            this.results[mouse][this.food][MOUSE_TURN][1] = 0;
            this.results[mouse][this.food][CAT_TURN][0] = CAT_WIN;
            this.results[mouse][this.food][CAT_TURN][1] = 0;
            queue.offer(new int[]{mouse, this.food, MOUSE_TURN});
            queue.offer(new int[]{mouse, this.food, CAT_TURN});
        }
        for (int cat = 0; cat < total; cat++) {
            int catRow = cat / this.cols, catCol = cat % this.cols;
            if (grid[catRow].charAt(catCol) == '#' || cat == this.food) {
                continue;
            }
            this.results[this.food][cat][MOUSE_TURN][0] = MOUSE_WIN;
            this.results[this.food][cat][MOUSE_TURN][1] = 0;
            this.results[this.food][cat][CAT_TURN][0] = MOUSE_WIN;
            this.results[this.food][cat][CAT_TURN][1] = 0;
            queue.offer(new int[]{this.food, cat, MOUSE_TURN});
            queue.offer(new int[]{this.food, cat, CAT_TURN});
        }
        // 拓扑排序
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mouse = state[0], cat = state[1], turn = state[2];
            int result = this.results[mouse][cat][turn][0];
            int moves = this.results[mouse][cat][turn][1];
            List<int[]> prevStates = getPrevStates(mouse, cat, turn);
            for (int[] prevState : prevStates) {
                int prevMouse = prevState[0], prevCat = prevState[1], prevTurn = prevState[2];
                if (this.results[prevMouse][prevCat][prevTurn][0] == UNKNOWN) {
                    boolean canWin = (result == MOUSE_WIN && prevTurn == MOUSE_TURN) || (result == CAT_WIN && prevTurn == CAT_TURN);
                    if (canWin) {
                        this.results[prevMouse][prevCat][prevTurn][0] = result;
                        this.results[prevMouse][prevCat][prevTurn][1] = moves + 1;
                        queue.offer(new int[]{prevMouse, prevCat, prevTurn});
                    } else {
                        this.degrees[prevMouse][prevCat][prevTurn]--;
                        if (this.degrees[prevMouse][prevCat][prevTurn] == 0) {
                            int loseResult = prevTurn == MOUSE_TURN ? CAT_WIN : MOUSE_WIN;
                            this.results[prevMouse][prevCat][prevTurn][0] = loseResult;
                            this.results[prevMouse][prevCat][prevTurn][1] = moves + 1;
                            queue.offer(new int[]{prevMouse, prevCat, prevTurn});
                        }
                    }
                }
            }
        }
        return this.results[startMouse][startCat][MOUSE_TURN][0] == MOUSE_WIN && this.results[startMouse][startCat][MOUSE_TURN][1] <= MAX_MOVES;
    }

    private List<int[]> getPrevStates(int mouse, int cat, int turn) {
        List<int[]> prevStates = new ArrayList<>();
        int mouseRow = mouse / this.cols, mouseCol = mouse % this.cols;
        int catRow = cat / this.cols, catCol = cat % this.cols;
        int prevTurn = turn == MOUSE_TURN ? CAT_TURN : MOUSE_TURN;
        int maxJump = prevTurn == MOUSE_TURN ? mouseJump : catJump;
        int startRow = prevTurn == MOUSE_TURN ? mouseRow : catRow;
        int startCol = prevTurn == MOUSE_TURN ? mouseCol : catCol;
        prevStates.add(new int[]{mouse, cat, prevTurn});
        for (int[] dir : this.dirs) {
            for (int i = startRow + dir[0], j = startCol + dir[1], jump = 1;
                 i >= 0 && i < this.rows && j >= 0 && j < this.cols && this.grid[i].charAt(j) != '#' && jump <= maxJump;
                 i += dir[0], j += dir[1], jump++) {
                int prevMouseRow = prevTurn == MOUSE_TURN ? i : mouseRow;
                int prevMouseCol = prevTurn == MOUSE_TURN ? j : mouseCol;
                int prevCatRow = prevTurn == MOUSE_TURN ? catRow : i;
                int prevCatCol = prevTurn == MOUSE_TURN ? catCol : j;
                int prevMouse = getPos(prevMouseRow, prevMouseCol);
                int prevCat = getPos(prevCatRow, prevCatCol);
                prevStates.add(new int[]{prevMouse, prevCat, prevTurn});
            }
        }
        return prevStates;
    }

    public int getPos(int row, int col) {
        return row * this.cols + col;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.canMouseWin(new String[] {"####F", "#C...", "M...."}, 1, 2)); // true
        System.out.println(slt.canMouseWin(new String[] {"M.C...F"}, 1, 4)); // true
        System.out.println(slt.canMouseWin(new String[] {"M.C...F"}, 1, 3)); // false
        System.out.println(slt.canMouseWin(new String[] {"C...#", "...#F", "....#", "M...."}, 2, 5)); // false
        System.out.println(slt.canMouseWin(new String[] {".M...", "..#..", "#..#.", "C#.#.", "...#F"}, 3, 1)); // true
    }

}
