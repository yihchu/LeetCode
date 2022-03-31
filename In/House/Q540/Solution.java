package In.House.Q540;

public class Solution {

//    // O(n)
//    public int singleNonDuplicate(int[] nums) {
//        int result = 0;
//        for (int n: nums) {
//            result ^= n;
//        }
//        return result;
//    }

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            mid = mid % 2 == 1 ? mid - 1: mid;
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
        System.out.println(slt.singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11})); // 10
    }

}


