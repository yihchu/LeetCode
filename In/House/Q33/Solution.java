package In.House.Q33;

public class Solution {

//    // O(n)
//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(slt.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3)); //-1
        System.out.println(slt.search(new int[] {1}, 0)); // -1
    }

}

