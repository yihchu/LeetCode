package In.House.Q447;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                int w = points[j][0] - points[i][0], h = points[j][1] - points[i][1];
                int d = w * w + h * h;
                if (!map.containsKey(d)) {
                    map.put(d, new LinkedList<>());
                }
                map.get(d).add(points[j]);
            }
            for (List<int[]> l: map.values()) {
                if (l.size() < 2) {
                    continue;
                }
                result += l.size() * (l.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}})); // 2
        System.out.println(slt.numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}})); // 2
        System.out.println(slt.numberOfBoomerangs(new int[][]{{1, 1}})); // 0
    }

}


