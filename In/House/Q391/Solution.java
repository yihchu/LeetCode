package In.House.Q391;

import java.util.*;

public class Solution {

//    /**
//     * 这种方法没办法处理部分重合的情况
//     * 其实可以把key设置成两个点中间的值，如1，2 -> 1.5
//     * 这样的话，如果有重合的情况发生
//     * 那必要存在某key对应的上下边界相比其他key来说，有缺失
//     *
//     * 但是犯懒了，懒得去实现了
//     */
//    public boolean isRectangleCover(int[][] rectangles) {
//        Map<Integer, List<int[]>> map = new HashMap<>();
//        int area = 0, left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE;
//        for (int[] rect: rectangles) {
//            left = left > rect[0] ? rect[0] : left;
//            bottom = bottom > rect[1] ? rect[1] : bottom;
//            right = right < rect[2] ? rect[2] : right;
//            top = top < rect[3] ? rect[3] : top;
//            area += (rect[3] - rect[1]) * (rect[2] - rect[0]);
//            int floor = rect[1], ceiling = rect[3];
//            for (int t = rect[0]; t <= rect[2]; ++t) {
//                if (!map.containsKey(t)) {
//                    List<int[]> l = new ArrayList<>();
//                    l.add(new int[]{floor, ceiling});
//                    map.put(t, l);
//                    continue;
//                }
//                List<int[]> layers = map.get(t);
//                List<int[]> newLayers = new ArrayList<>();
//                boolean added = false;
//                for (int i = 0; i < layers.size(); ++i) {
//                    int[] layer = layers.get(i);
//                    if (layer[1] < floor) {
//                        newLayers.add(layer);
//                        continue;
//                    }
//                    floor = layer[0] < floor ? layer[0] : floor;
//                    ceiling = layer[1] > ceiling ? layer[1] : ceiling;
//                    int j = i + 1;
//                    for (; j < layers.size(); ++j) {
//                        layer = layers.get(j);
//                        if (layer[0] <= ceiling) {
//                            ceiling = ceiling < layer[1] ? layer[1] : ceiling;
//                        } else {
//                            break;
//                        }
//                    }
//                    i = j;
//                    newLayers.add(new int[] {floor, ceiling});
//                    added = true;
//                    floor = rect[1];
//                    ceiling = rect[3];
//                }
//                if (!added) {
//                    newLayers.add(new int[] {floor, ceiling});
//                }
//                map.put(t, newLayers);
//            }
//        }
//        if (area != (right - left) * (top - bottom)) {
//            return false;
//        }
//        for (List<int[]> l: map.values()) {
//            if (l.size() != 1) {
//                return false;
//            }
//            if (l.get(0)[0] != bottom || l.get(0)[1] != top) {
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     *  思路其实很简单
     *  最后形成的大矩形，如果存在，那么只有(左下，左上，右下，右上四个端点只出现一次，其他断点应该都是成对出现的)，
     *  而且，最后的大矩形面积应该恰好等于所有小矩形的面积和。
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MIN_VALUE, bottom = Integer.MAX_VALUE;
        int len = rectangles.length, area = 0;
        Set<Point> singlePoints = new HashSet<>();
        for (int[] rect: rectangles) {
            left = left > rect[0] ? rect[0] : left;
            bottom = bottom > rect[1] ? rect[1] : bottom;
            right = right < rect[2] ? rect[2] : right;
            top = top < rect[3] ? rect[3] : top;
            area += (rect[3] - rect[1]) * (rect[2] - rect[0]);
            Point[] points = new Point[] {new Point(rect[0], rect[1]), new Point(rect[0], rect[3]), new Point(rect[2], rect[1]), new Point(rect[2], rect[3])};
            for (Point point: points) {
                if (singlePoints.contains(point)) {
                    singlePoints.remove(point);
                    continue;
                }
                singlePoints.add(point);
            }
        }
        if (singlePoints.size() != 4 || area != (top - bottom) * (right - left)
                || (!singlePoints.contains(new Point(left, bottom))
                || !singlePoints.contains(new Point(left, top))
                || !singlePoints.contains(new Point(right, bottom))
                || !singlePoints.contains(new Point(right, top)))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isRectangleCover(new int[][]{ // true
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}}));
        System.out.println(slt.isRectangleCover(new int[][]{ // false
                {1, 1, 2, 3},
                {1, 3, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 4, 4}}));
        System.out.println(slt.isRectangleCover(new int[][]{ // false
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {3, 2, 4, 4}}));
        System.out.println(slt.isRectangleCover(new int[][]{ // false
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {1, 3, 2, 4},
                {2, 2, 4, 4}}));
        System.out.println(slt.isRectangleCover(new int[][] { // true
                {0, 0, 4, 1},
                {7, 0, 8, 2},
                {5, 1, 6, 3},
                {6, 0, 7, 2},
                {4, 0, 5, 1},
                {4, 2, 5, 3},
                {2, 1, 4, 3},
                {0, 2, 2, 3},
                {0, 1, 2, 2},
                {6, 2, 8, 3},
                {5, 0, 6, 1},
                {4, 1, 5, 2}
        }));
        System.out.println(slt.isRectangleCover(new int[][] { // false
                {0, 0, 1, 1},
                {0, 1, 3, 2},
                {1, 0, 2, 2}
        }));
        System.out.println(slt.isRectangleCover(new int[][] { // false
                {1, 1, 3, 3},
                {2, 2, 4, 4},
                {4, 1, 5, 4},
                {1, 3, 2, 4}
        }));
        System.out.println(slt.isRectangleCover(new int[][] { // false
                {0, 0, 1, 1},
                {0, 0, 2, 1},
                {1, 0, 2, 1},
                {0, 2, 2, 3}
        }));
    }

}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

}

