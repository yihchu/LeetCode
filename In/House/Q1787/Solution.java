package In.House.Q1787;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    public int minChanges(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[1024];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < k; ++i) {
            int[] tmp = new int[1024];
            int size = 0;
            Map<Integer, Integer> h = new HashMap<>();
            for (int j = i; j < len; j += k) {
                ++size;
                h.compute(nums[j], (key, val) -> Objects.isNull(val) ? 1 : ++val);
            }

            Arrays.fill(tmp, Arrays.stream(result).min().getAsInt());
            for (int j = 0; j < 1024; ++j) {
                for (Map.Entry<Integer, Integer> entry: h.entrySet()) {
                    int x = entry.getKey(), count = entry.getValue();
                    int t = result[j ^ x] - count;
                    tmp[j] = tmp[j] > t ? t : tmp[j];
                }
            }

            for (int j = 0; j < 1024; ++j) {
                tmp[j] += size;
            }
            result = tmp;
        }
        return result[0];
    }

    public static void main(String[] args) {
        /*
        1 <= k <= nums.length <= 2000
        0 <= nums[i] < 2^10
        */
        Solution slt = new Solution();
        System.out.println(slt.minChanges(new int[]{1, 2, 0, 3, 0}, 1)); // 3 [0,0,0,0,0]
        System.out.println(slt.minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3)); // 3 [3,4,7,3,4,7,3,4,7]
        System.out.println(slt.minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3)); // 3 [1,2,3,1,2,3,1,2,3]
        System.out.println(slt.minChanges(new int[]{26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11}, 3)); // 11

        int[] arr = new int[2000];
        Arrays.fill(arr, 1);
        System.out.println(slt.minChanges(arr, 1)); // 2000

    }

}

