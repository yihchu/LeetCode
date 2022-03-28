package In.House.Q704;

public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(slt.search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
    }

}

