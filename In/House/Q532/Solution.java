package In.House.Q532;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int j = len - 1; j > 0; --j) {
            for (int i = 0; i < j; ++i) {
                if (nums[j] - nums[i] < k) {
                    break;
                }
                if (nums[j] - nums[i] > k) {
                    continue;
                }
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findPairs(new int[] {3, 1, 4, 1, 5}, 2)); // 2
        System.out.println(slt.findPairs(new int[] {1, 2, 3, 4, 5}, 1)); // 4
        System.out.println(slt.findPairs(new int[] {1, 3, 1, 5, 4}, 0)); // 1
    }

}
