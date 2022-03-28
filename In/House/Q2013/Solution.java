package In.House.Q2013;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class DetectSquares {

    private Map<Point, Integer> pointsMap;

    public DetectSquares() {
        this.pointsMap = new HashMap<>();
    }

    public void add(int[] p) {
        Point point = Point.convert(p);
        if (this.pointsMap.containsKey(point)) {
             this.pointsMap.put(point, this.pointsMap.get(point) + 1);
             return;
        }
        this.pointsMap.put(point, 1);
    }

    public int count(int[] p) {
        int sum = 0;
        Point point = Point.convert(p);
        for (Map.Entry<Point, Integer> entry: this.pointsMap.entrySet()) {
            Point tmp = entry.getKey();
            if (point.x == tmp.x || point.y == tmp.y) {
                continue;
            }
            if (Math.abs(point.x - tmp.x) != Math.abs(point.y - tmp.y)) {
                continue;
            }
            Integer v1 = this.pointsMap.get(Point.convert(new int[] {point.x, tmp.y}));
            if (Objects.isNull(v1)) {
                continue;
            }
            Integer v2 = this.pointsMap.get(Point.convert(new int[] {tmp.x, point.y}));
            if (Objects.isNull(v2)) {
                continue;
            }
            sum += entry.getValue() * v1 * v2;
        }
        return sum;
    }

    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[] {3, 10});
        ds.add(new int[] {11, 2});
        ds.add(new int[] {3, 2});
        System.out.println(ds.count(new int[] {11, 10}));
        ds.add(new int[] {14, 2});
        ds.add(new int[] {11, 2});
        System.out.println(ds.count(new int[] {11, 10}));
    }


}

class Point {
    public int x;
    public int y;

    public static Point convert(int[] p) {
        Point point = new Point();
        point.x = p[0];
        point.y = p[1];
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */