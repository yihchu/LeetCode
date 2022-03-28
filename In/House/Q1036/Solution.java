package In.House.Q1036;

import java.util.*;

public class Solution {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int len = blocked.length;
        if (len < 2) {
            return true;
        }
        int row = extract(build(blocked, source, target, true), blocked, source, target, true);
        int col = extract(build(blocked, source, target, false), blocked, source, target, false);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < len; ++i) {
            matrix[blocked[i][0]][blocked[i][1]] = 1;
        }
        return findWay(matrix, source[0], source[1], target);
    }

    private List<Tuple> build(int[][] blocked, int[] source, int[] target, boolean isX) {
        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < blocked.length; ++i) {
            tuples.add(new Tuple(blocked[i][isX ? 0 : 1], i));
        }
        tuples.add(new Tuple(source[isX ? 0 : 1], 1000));
        tuples.add(new Tuple(target[isX ? 0 : 1], 2000));
        return tuples;
    }

    private int extract(List<Tuple> tuples, int[][] blocked, int[] source, int[] target, boolean isX) {
        Collections.sort(tuples, Comparator.comparingInt(t -> t.val));
        Tuple last = tuples.get(0);
        int len = last.val == 0 ? 1 : 2;
        if (last.val > 0) {
            array(last.idx, blocked, source, target)[isX ? 0 : 1] = len - 1;
        }
        for (int i = 1; i < tuples.size(); ++i) {
            Tuple cur = tuples.get(i);
            int[] tmp = array(cur.idx, blocked, source, target);
            if (cur.val == last.val + 1) {
                ++len;
            } else if (cur.val > last.val + 1) {
                len += 2;
            }
            tmp[isX ? 0 : 1] = len - 1;
            last = cur;
        }
        return tuples.get(tuples.size() - 1).val == 999999 ? len: len + 1;
    }

    private boolean findWay(int[][] map, int x, int y, int[] target) {
        if (x == target[0] && y == target[1]) {
            return true;
        }
        map[x][y] = 1;
        if (x > 0 && map[x - 1][y] == 0) {
            if (findWay(map, x - 1, y, target)) {
                return true;
            }
        }
        if (x + 1 < map.length && map[x + 1][y] == 0) {
            if (findWay(map, x + 1, y, target)) {
                return true;
            }
        }
        if (y > 0 && map[x][y - 1] == 0) {
            if (findWay(map, x, y - 1, target)) {
                return true;
            }
        }
        if (y + 1 < map[0].length && map[x][y + 1] == 0) {
            if (findWay(map, x, y + 1, target)) {
                return true;
            }
        }
        return false;
    }

    private int[] array(int idx, int[][] blocked, int[] source, int[] target) {
        if (idx < 1000) {
            return blocked[idx];
        }
        return idx == 1000 ? source : target;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isEscapePossible(new int[][] {{0, 1}, {1, 0}}, new int[] {0, 0}, new int[] {0, 2})); // false
        System.out.println(slt.isEscapePossible(new int[][] {}, new int[] {0, 0}, new int[] {999999, 999999})); // true
        System.out.println(slt.isEscapePossible(new int[][] {{691938, 300406}, {710196, 624190}, {858790, 609485}, {268029, 225806}, {200010, 188664}, {132599, 612099}, {329444, 633495}, {196657, 757958}, {628509, 883388}}, new int[] {655988, 180910}, new int[] {267728, 840949})); // true

    }

}

class Tuple {
    public int val;
    public int idx;

    public Tuple(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
