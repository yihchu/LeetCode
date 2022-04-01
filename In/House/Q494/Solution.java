package In.House.Q494;

public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        return findTargetSumWays(nums, len - 1, target);
    }

    public int findTargetSumWays(int[] nums, int end, int target) {
        if (end == 0) {
            int sum = nums[0] == target ? 1 : 0;
            sum += 0 - nums[0] == target ? 1 : 0;
            return sum;
        }
        return findTargetSumWays(nums, end - 1, target + nums[end])
                + findTargetSumWays(nums, end - 1, target - nums[end]);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)); // 5
        System.out.println(slt.findTargetSumWays(new int[]{1}, 1)); // 1
        System.out.println(slt.findTargetSumWays(new int[]{0, 1}, 1)); //
        System.out.print(slt.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1)); // 256
    }
}

