package In.House.Q1001;

import java.util.*;

public class Solution {

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> xx = new HashMap<>();
        Map<Integer, Integer> yy = new HashMap<>();
        Map<Integer, Integer> dx = new HashMap<>();
        Map<Integer, Integer> dy = new HashMap<>();
        Set<Point> points = new HashSet<>();
        for (int[] lamp: lamps) {
            if (!points.add(Point.of(lamp))) {
                continue;
            }
            xx.put(lamp[1], xx.getOrDefault(lamp[1], 0) + 1);
            yy.put(lamp[0], yy.getOrDefault(lamp[0], 0) + 1);
            dx.put(lamp[0] - lamp[1], dx.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            dy.put(lamp[0] + lamp[1], dy.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            int[] query = queries[i];
            result[i] = (xx.containsKey(query[1]) || yy.containsKey(query[0])
                    || dx.containsKey(query[0] - query[1]) || dy.containsKey(query[0] + query[1])) ? 1 : 0;
            for (int x = query[0] - 1; x <= query[0] + 1; ++x) {
                for (int y = query[1] - 1; y <= query[1] + 1; ++y) {
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }
                    if (points.remove(Point.of(x, y))) {
                        turnOff(xx, y);
                        turnOff(yy, x);
                        turnOff(dx, x - y);
                        turnOff(dy, x + y);
                    }
                }
            }
        }
        return result;
    }

    private void turnOff(Map<Integer, Integer> map, int key) {
        int v = map.getOrDefault(key, 0);
        if (v <= 1) {
            map.remove(key);
            return;
        }
        map.put(key, v - 1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {4, 4}}, new int[][] {{1, 1}, {1, 0}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {4, 4}}, new int[][] {{1, 1}, {1, 1}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.gridIllumination(5, new int[][] {{0, 0}, {0, 4}}, new int[][] {{0, 4}, {0, 1}, {1, 4}}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

class Point {
    int x, y;

    public static Point of(int[] arr) {
        return of(arr[0], arr[1]);
    }

    public static Point of(int x, int y) {
        Point point = new Point();
        point.x = x;
        point.y = y;
        return point;
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

/*
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> xx = new HashMap<>();
        Map<Integer, Integer> yy = new HashMap<>();
        Map<Integer, Integer> dx = new HashMap<>();
        Map<Integer, Integer> dy = new HashMap<>();
        Set<Long> points = new HashSet<>();
        for (int[] lamp: lamps) {
            if (!points.add(hash(lamp[0], lamp[1])))
        }
    }
    private long hash(int x, int y) {
        return (long) x + ((long) y << 32);
    }
 */