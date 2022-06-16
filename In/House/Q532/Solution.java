package In.House.Q532;

import java.util.Arrays;

public class Solution {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, len = nums.length;
        for (int j = len - 1; j > 0; ) {
            if (nums[j] - nums[0] < k) {
                break;
            }
            int l = 0, r = j - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                int diff = nums[j] - nums[mid];
                if (diff > k) {
                    l = mid + 1;
                } else if (diff < k) {
                    r = mid - 1;
                } else {
                    ++count;
                    break;
                }
            }
            --j;
            while (j > 0 && nums[j] == nums[j + 1]) {
                --j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findPairs(new int[] {3, 1, 4, 1, 5}, 2)); // 2
        System.out.println(slt.findPairs(new int[] {1, 2, 3, 4, 5}, 1)); // 4
        System.out.println(slt.findPairs(new int[] {1, 3, 1, 5, 4}, 0)); // 1
        System.out.println(slt.findPairs(new int[] {1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3)); // 2
        System.out.println(slt.findPairs(new int[] {1, 1, 1, 2, 2}, 0)); // 2
    }

}
