package In.House.Q229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * O(n)的解法，在官方题解中，使用的是摩尔投票法~
     * 我肯定是想不到哇~
     */

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int thres = len / 3;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len ; ++i) {
            int count = map.getOrDefault(nums[i], 0);
            if (count < 0) {
                continue;
            }
            if (count >= thres) {
                result.add(nums[i]);
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], count + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.majorityElement(new int[] {3, 2, 3}).forEach(a -> System.out.print(a + " "));
        System.out.println();
        slt.majorityElement(new int[] {1}).forEach(a -> System.out.print(a + " "));
        System.out.println();
        slt.majorityElement(new int[] {1, 1, 1, 3, 3, 2, 2, 2}).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

