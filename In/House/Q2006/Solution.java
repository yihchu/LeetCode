package In.House.Q2006;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey() + k;
            if (!map.containsKey(key)) {
                continue;
            }
            sum += entry.getValue() * map.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countKDifference(new int[] {1, 2, 2, 1}, 1)); // 4
        System.out.println(slt.countKDifference(new int[] {1, 3}, 3)); // 0
        System.out.println(slt.countKDifference(new int[] {3, 2, 1, 5, 4}, 2)); // 3
        System.out.println(slt.countKDifference(new int[] {10, 2, 10, 9, 1, 6, 8, 9, 2, 8}, 5)); // 1
    }
}
