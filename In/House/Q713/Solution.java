package In.House.Q713;

public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; ++i) {
            int cur = 1;
            for (int j = i; j < len; ++j) {
                int tmp = cur * nums[j];
                if (tmp < k) {
                    ++count;
                    cur = tmp;
                    continue;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100)); // 8
        System.out.println(slt.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0)); // 0
    }

}
