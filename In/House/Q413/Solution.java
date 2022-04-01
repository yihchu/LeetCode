package In.House.Q413;

public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; ++i) {
            int gap = nums[i + 1] - nums[i];
            if (gap != nums[i + 2] - nums[i + 1]) {
                continue;
            }
            ++count;
            for (int j = i + 3; j < len; ++j) {
                if (nums[j] - nums[j - 1] != gap) {
                    break;
                }
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(slt.numberOfArithmeticSlices(new int[]{1})); // 1
    }

}

