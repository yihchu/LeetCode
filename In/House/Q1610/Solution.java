package In.House.Q1610;

import java.util.*;

public class Solution {


    public int visiblePoints1(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        List<Double> polarDegrees = new ArrayList<>();
        int locationX = location.get(0);
        int locationY = location.get(1);
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0);
            int y = points.get(i).get(1);
            if (x == locationX && y == locationY) {
                sameCnt++;
                continue;
            }
            Double degree = Math.atan2(y - locationY, x - locationX);
            polarDegrees.add(degree);
        }
        Collections.sort(polarDegrees);

        int m = polarDegrees.size();
        for (int i = 0; i < m; ++i) {
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        int right = 0;
        double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; ++i) {
            Double curr = polarDegrees.get(i) + toDegree;
            while (right < polarDegrees.size() && polarDegrees.get(right) <= curr) {
                right++;
            }
            maxCnt = Math.max(maxCnt, right - i);
        }
        return maxCnt + sameCnt;
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int overlaps = 0;
        List<Double> degrees = new ArrayList<>();
        int ox = location.get(0), oy = location.get(1);
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0), y = points.get(i).get(1);
            if (x == ox && y == oy) {
                ++ overlaps;
                continue;
            }
            degrees.add(Math.atan2(y - oy, x - ox));
        }
        Collections.sort(degrees);
        int size = degrees.size();
        for (int i = 0; i < size; ++i) {
            degrees.add(degrees.get(i) + 2 * Math.PI);
        }
        int max = 0, idx = 0;
        double degree = angle * Math.PI / 180;
        for (int i = 0; i < size; ++i) {
            Double cur = degrees.get(i) + degree;
            while (idx < degrees.size() && degrees.get(idx) <= cur) {
                ++ idx;
            }
            max = Math.max(max, idx - i);
        }
        return max + overlaps;
    }

    private List<List<Integer>> toList(int[][] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        int l = arrays.length;
        for (int i = 0; i < l; ++i) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < arrays[i].length; ++j) {
                tmp.add(arrays[i][j]);
            }
            result.add(tmp);
        }
        return result;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> result = new ArrayList<>();
        int len = array.length;
        for (int i = 0; i < len; ++i) {
            result.add(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.visiblePoints(slt.toList(new int[][]{ {2, 1}, {2, 2}, {3, 3} } ), 90, slt.toList(new int[] {1, 1}))); // 3
//        System.out.println(slt.visiblePoints(slt.toList(new int[][]{ {2, 1}, {2, 2}, {3, 4}, {3, 4} } ), 90, slt.toList(new int[] {1, 1}))); // 4
//        System.out.println(slt.visiblePoints(slt.toList(new int[][]{ {1, 0}, {2, 1} }), 13, slt.toList(new int[] {1, 1} ))); // 1
        System.out.println(slt.visiblePoints(slt.toList(new int[][]{ {0, 0}, {0, 2} }), 90, slt.toList(new int[] {1, 1} ))); // 2
        System.out.println(slt.visiblePoints1(slt.toList(new int[][]{ {0, 0}, {0, 2} }), 90, slt.toList(new int[] {1, 1} ))); // 2
    }

    /**
     * 这一套做下来，好好调整一下，应该也是可行的
     * 但是越写越麻烦，先搁置了
     * 记录下思路，通过sin函数记录角度，但是不同象限似乎无法比较，所以再记录一下以location为原点的个点的象限
     * 比较时，先比较象限，象限相同再比较角度
     * 讲道理，我觉得，就是很麻烦，应该是没太大问题可以实现的
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        Map<Pos, Integer> map = new HashMap<>();
        List<Pos> poses = new ArrayList<>();
        int lX = location.get(0), lY = location.get(1);
        int sameCount = 0;
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0), y = points.get(i).get(1);
            if (lX == x && lY == y) {
                ++ sameCount;
                continue;
            }
            poses.add(new Pos(lX, lY, x, y));
        }
        Collections.sort(poses);
        Pos l = new Pos(0), r = new Pos(angle);
        int times = 360 / angle + 1;
        int idx = 0, max = 0;
        for (int i = 0; i < times; ++i) {
            int tmp = 0;
            for (; idx < poses.size(); ++idx) {
                tmp += (poses.get(idx) >= l && poses.get(idx) <= r ? 1 : 0);
            }
            max = max < tmp ? tmp : max;
        }
        return max + sameCount;
    }

    public static class Pos implements Comparable<Pos> {
        public int quadrant;
        public double sin;

        public Pos(int angle) {
            if (angle < 90) {
                this.quadrant = 1;
            } else if (angle < 180) {
                this.quadrant = 2;
            } else if (angle < 270) {
                this.quadrant = 3
            } else {
                this.quadrant = 4;
            }
            this.sin = Math.sin(Math.toRadians(angle));
        }

        public Pos(int lX, int lY, int x, int y) {
            if (x >= lX && y >= lY) {
                this.quadrant = 1;
            } else if (x <= lX && y >= lY) {
                this.quadrant = 2;
            } else if (x <= lX && y <= lY) {
                this.quadrant = 3;
            } else {
                this.quadrant = 4;
            }
            this.sin = (lY == y ? 0 : (lX == x ? 1 : (y - lY) / Math.sqrt((double)(x - lX) * (x - lX) + (y - lY) * (y - lY))) );
        }


        @Override
        public int compareTo(Pos p) {
            if (this.quadrant == p.quadrant) {
                return (this.quadrant == 1 || this.quadrant == 4 ? this.sin - p.sin : p.sin - this.sin) < 0 ? 1 : 0;
            }
            return this.quadrant - p.quadrant;
        }
    }
     */
}

/**
Ques: 可见点的最大数目
Link: https://leetcode-cn.com/problems/maximum-number-of-visible-points/

给你一个点数组points和一个表示角度的整数angle，你的位置是location，其中location = [pos[x], pos[y]]且points[i] = [x[i], y[i]]都表示X-Y平面上的整数坐标。
最开始，你面向东方进行观测。你不能进行移动改变位置，但可以通过自转调整观测角度。换句话说，pos[x]和pos[y]不能改变。你的视野范围的角度用angle表示，这决定了你观测任意方向时可以多宽。设d为你逆时针自转旋转的度数，那么你的视野就是角度范围[d - angle/2, d + angle/2]所指示的那片区域。
对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度位于你的视野中，那么你就可以看到它。
同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
返回你能看到的点的最大数目。

示例1(图1.png)：
输入：points = [[2, 1], [2, 2], [3, 3]], angle = 90, location = [1, 1]
输出：3
解释：阴影区域代表你的视野。在你的视野中，所有的点都清晰可见，尽管[2, 2]和[3, 3]在同一条直线上，你仍然可以看到[3, 3]。

示例2：
输入：points = [[2, 1], [2, 2], [3, 4], [1, 1]], angle = 90, location = [1, 1]
输出：4
解释：在你的视野中，所有的点都清晰可见，包括你所在位置的那个点。

示例3(图2.png, 3.png)：
输入：points = [[1, 0], [2, 1]], angle = 13, location = [1, 1]
输出：1
解释：如图所示，你只能看到两点之一。

提示：
1 <= points.length <= 10^5
points[i].length == 2
location.length == 2
0 <= angle < 360
0 <= pos[x], pos[y], x[i], y[i] <= 100

*/