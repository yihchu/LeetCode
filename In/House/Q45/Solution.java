package In.House.Q45;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final static int MAX = 10001;

    public int jump(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return jump(0, nums, map);
    }

    private int jump(int pos, int[] nums, Map<Integer, Integer> map) {
        if (pos == nums.length - 1) {
            return 0;
        }
        if (nums[pos] == 0) {
            return MAX;
        }
        int min = MAX, border = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = border; i > pos; --i) {
            if (map.containsKey(i)) {
                min = Math.min(min, map.get(i));
            } else {
                min = Math.min(min, jump(i, nums, map));
            }
        }
        map.put(pos, min + 1);
        return min + 1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.jump(new int[] {2, 3, 1, 1, 4})); // 2
        System.out.println(slt.jump(new int[] {2, 3, 0, 1, 4})); // 2
        System.out.println(slt.jump(new int[] {3, 4, 3, 2, 5, 4, 3})); // 3
    }

}
