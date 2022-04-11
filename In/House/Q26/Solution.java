package In.House.Q26;

public class Solution {

    public void move(int[] nums, int start, int end) {
        for (int i = start; i + 1< end; ++i) {
            nums[i] = nums[i + 1];
        }
    }
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int current = nums[0];
        int count = 0;
        for (int i = 1; i < len - count; ) {
            if (nums[i] == current) {
                move(nums, i, len - count);
                ++count;
            } else {
                current = nums[i];
                ++i;
            }
        }
        return len - count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] array1 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result1 = slt.removeDuplicates(array1);
        for (int i = 0; i < result1; ++i) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
    }
}


