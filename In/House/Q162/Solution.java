package In.House.Q162;

public class Solution {

    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        if (start == end) {
            return 0;
        }
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else if (mid <= end - 1 && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findPeakElement(new int[] {1, 2, 3, 1})); // 2
        System.out.println(slt.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4})); // 1 or 5
        System.out.println(slt.findPeakElement(new int[] {1, 2})); // 1
    }

}

