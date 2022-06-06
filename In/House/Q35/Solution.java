package In.House.Q35;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.searchInsert(new int[] {1, 3, 5, 6}, 5)); // 2
        System.out.println(slt.searchInsert(new int[] {1, 3, 5, 6}, 2)); // 1
        System.out.println(slt.searchInsert(new int[] {1, 3, 5, 6}, 7)); // 4
    }

}
