package In.House.Q446;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int count = 0;
        Map<Long, Integer>[] map = new Map[len];
        for (int i = 0; i < len; ++i) {
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = nums[i] - nums[j];
                int tmp = map[j].getOrDefault(d, 0);
                count += tmp;
                map[i].put(d, map[i].getOrDefault(d, 0) + tmp + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(slt.numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
    }

}


