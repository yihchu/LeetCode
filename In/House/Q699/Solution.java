package In.House.Q699;

import java.util.*;

public class Solution {

    public List<Integer> fallingSquares(int[][] positions) {
        Map<Integer, List<Range>> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> result = new ArrayList<>();

        map.put(positions[0][1], new ArrayList<>() {{add(new Range(positions[0][0], positions[0][0] + positions[0][1] - 1));}});
        queue.add(positions[0][1]);
        result.add(positions[0][1]);

        int len = positions.length, max = positions[0][1];
        for (int i = 1; i < len; ++i) {
            Range current = new Range(positions[i][0], positions[i][0] + positions[i][1] - 1);
            PriorityQueue<Integer> tmp = new PriorityQueue<>((a, b) -> b - a);
            boolean flag = false;
            while (!queue.isEmpty() && !flag) {
                int layer = queue.poll();
                tmp.add(layer);
                List<Range> ranges = map.get(layer);
                for (Range range: ranges) {
                    if (!isOverlap(range, current)) {
                        continue;
                    }
                    int height = layer + positions[i][1];
                    if (map.containsKey(height)) {
                        map.get(height).add(current);
                    } else {
                        tmp.add(height);
                        map.put(height, new ArrayList<>() {{add(current);}});
                    }
                    max = max < height ? height : max;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                while (!queue.isEmpty()) {
                    tmp.add(queue.poll());
                }
            } else {
                max = max < positions[i][1] ? positions[i][1] : max;
                if (map.containsKey(positions[i][1])) {
                    map.get(positions[i][1]).add(current);
                } else {
                    tmp.add(positions[i][1]);
                    map.put(positions[i][1], new ArrayList<>() {{add(current);}});
                }
            }
            result.add(max);
            queue = tmp;
        }
        return result;
    }

    public static boolean isOverlap(Range r1, Range r2) {
        return (r1.getStart() <= r2.getStart() && r1.getEnd() >= r2.getStart()) || (r2.getStart() <= r1.getStart() && r2.getEnd() >= r1.getStart());
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.fallingSquares(new int[][] {{1, 2}, {2, 3}, {6, 1}}).forEach(a -> System.out.print(a + " ")); // [2, 5, 5]
        System.out.println();
        slt.fallingSquares(new int[][] {{100, 100}, {200, 100}}).forEach(a -> System.out.print(a + " ")); // [100, 100]
        System.out.println();
        slt.fallingSquares(new int[][] {{6, 1}, {9, 2}, {2, 4}}).forEach(a -> System.out.print(a + " ")); // [1, 2, 4]
        System.out.println();
    }

}

class Range implements Comparable<Range> {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    @Override
    public int compareTo(Range o) {
        return o.start - this.start;
    }
}