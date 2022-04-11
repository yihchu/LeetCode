package In.House.Q34;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l - 1 > -1 && nums[l] == nums[l - 1]) {
                    --l;
                }
                while (r + 1 < len && nums[r] == nums[r + 1]) {
                    ++r;
                }
                return new int[] {l, r};
            } else if (nums[mid] < target) {
                l = mid + 1;
                while (l < r && l + 1 < len && nums[l] == nums[l + 1]) {
                    ++l;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
                while (r > l && r - 1 > -1 && nums[r] == nums[r - 1]) {
                    --r;
                }
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8)).forEach(a -> System.out.print(a + " ")); // [3, 4]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] { }, 0)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {1}, 1)).forEach(a -> System.out.print(a + " ")); // [0, 0]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {1}, 0)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
        Arrays.stream(slt.searchRange(new int[] {2, 2}, 3)).forEach(a -> System.out.print(a + " ")); // [-1, -1]
        System.out.println();
    }

}

