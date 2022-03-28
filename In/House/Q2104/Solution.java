package In.House.Q2104;

public class Solution {

    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long result = 0;
        for (int i = 0; i < len; ++i) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < len; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (max - min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.subArrayRanges(new int[] {1, 2, 3})); // 4
        System.out.println(slt.subArrayRanges(new int[] {1, 3, 3})); // 4
        System.out.println(slt.subArrayRanges(new int[] {4, -2, -3, 4, 1})); // 59
    }

}