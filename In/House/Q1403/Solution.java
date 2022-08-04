package In.House.Q1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        int thres = Arrays.stream(nums).sum() / 2;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i > -1; --i) {
            sum += nums[i];
            result.add(nums[i]);
            if (sum > thres) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.minSubsequence(new int[] {4, 3, 10, 9, 8}).forEach(a -> System.out.print(a + " ")); // [10, 9]
        System.out.println();
        slt.minSubsequence(new int[] {4, 4, 7, 6, 7}).forEach(a -> System.out.print(a + " ")); // [7, 7, 6]
        System.out.println();
        slt.minSubsequence(new int[] {6}).forEach(a -> System.out.print(a + " ")); // [6]
        System.out.println();
    }

}
