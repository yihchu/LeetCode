package In.House.Q593;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Long, Integer> map = new HashMap<>();
        calc(p1, new int[][] {p2, p3, p4}, map);
        calc(p2, new int[][] {p3, p4}, map);
        calc(p3, new int[][] {p4}, map);
        if (map.size() != 2) {
            return false;
        }
        long key1 = -1, key2 = -1;
        for (long key: map.keySet()) {
            if (key1 < 0) {
                key1 = key;
            } else {
                key2 = key;
            }
        }
        int val1 = map.get(key1), val2 = map.get(key2);
        return key1 < key2 ? key1 + key1 == key2 && val2 + val2 == val1 : key2 + key2 == key1 && val1 + val1 == val2;
    }

    private void calc(int[] p, int[][] arrs, Map<Long, Integer> map) {
        for (int[] arr: arrs) {
            long diff = (p[0] - arr[0]) * (p[0] - arr[0]) + (p[1] - arr[1]) * (p[1] - arr[1]);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 1})); // true
        System.out.println(slt.validSquare(new int[] {0, 0}, new int[] {1, 1}, new int[] {1, 0}, new int[] {0, 12})); // false
        System.out.println(slt.validSquare(new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1})); // true
    }

}