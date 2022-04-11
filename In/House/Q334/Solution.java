package In.House.Q334;

public class Solution {

//    public boolean increasingTriplet(int[] nums) {
//        int len = nums.length;
//        if (len < 3) {
//            return false;
//        }
//        int[] left = new int[len];
//        left[0] = nums[0];
//        for (int i = 1; i < len; ++i) {
//            left[i] = Math.min(left[i - 1], nums[i]);
//        }
//        int[] right = new int[len];
//        right[len - 1] = nums[len - 1];
//        for (int i = len - 2; i >= 0; --i) {
//            right[i] = Math.max(right[i + 1], nums[i]);
//        }
//        for (int i = 1; i < len - 1; ++i) {
//            if (nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int a = nums[0], b = Integer.MAX_VALUE;
        for (int i = 1; i < len; ++i) {
            int c = nums[i];
            if (c > b) {
                return true;
            } else if (c > a) {
                b = c;
            } else {
                a = c;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.increasingTriplet(new int[] {1, 2, 3, 4, 5})); // true
        System.out.println(slt.increasingTriplet(new int[] {5, 4, 3, 2, 1})); // false
        System.out.println(slt.increasingTriplet(new int[] {2, 1, 5, 0, 4, 6})); // true
    }

}

