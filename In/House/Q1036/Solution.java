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

/**
Ques: 逃离大迷宫
Link: https://leetcode-cn.com/problems/escape-a-large-maze/

在一个10^6 x 10^6的网格中，每个网格上方格的坐标为(x, y)。
现在从源方格source = [s[x], s[y]]开始出发，意图赶往目标方格target = [t[x], t[y]]。数组blocked是封锁的方格列表，其中每个blocked[i] = [x[i], y[i]]表示坐标为(x[i], y[i])的方格是禁止通行的。
每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表blocked上。同时，不允许走出网格。
只有在可以通过一系列的移动从源方格source到达目标方格target 时才返回true。否则，返回false。

示例1：
输入：blocked = [[0, 1], [1, 0]], source = [0, 0], target = [0, 2]
输出：false
解释：
从源方格无法到达目标方格，因为我们无法在网格中移动。
无法向北或者向东移动是因为方格禁止通行。
无法向南或者向西移动是因为不能走出网格。

示例2：
输入：blocked = [], source = [0, 0], target = [999999, 999999]
输出：true
解释：
因为没有方格被封锁，所以一定可以到达目标方格。

提示：
0 <= blocked.length <= 200
blocked[i].length == 2
0 <= x[i], y[i] < 10^6
source.length == target.length == 2
0 <= s[x], s[y], t[x], t[y] < 10^6
source != target
题目数据保证source和target不在封锁列表内

*/