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

