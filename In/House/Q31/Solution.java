package In.House.Q31;

import java.util.Arrays;

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void test(int[] nums) {
        System.out.print(">>>>> before: ");
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Solution slt = new Solution();
        slt.nextPermutation(nums);
        System.out.print("<<<<< after: ");
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 3});
        test(new int[] {3, 2, 1});
        test(new int[] {1, 1, 5});
    }

}

