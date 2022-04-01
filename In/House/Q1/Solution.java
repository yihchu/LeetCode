package In.House.Q1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    private static void print(int[] arr) {
        System.out.println(">>>>> result = [" + arr[0] + ", " + arr[1] + "].");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.twoSum(new int[] {2, 7, 11, 15}, 9)); // [0, 1]
        print(slt.twoSum(new int[] {3, 2, 4}, 6)); // [1, 2]
        print(slt.twoSum(new int[] {3, 3}, 6)); // [0, 1]
    }

}

