package In.House.Q1791;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findCenter(int[][] edges) {
        int len = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; len > 2 && i < 3 || i < 2; ++i) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 3 || len == 2 && entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findCenter(new int[][] {{1, 2}, {2, 3}, {4, 2}})); // 2
        System.out.println(slt.findCenter(new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}})); // 1
    }

}
