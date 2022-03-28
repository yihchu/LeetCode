package In.House.Q747;

public class Solution {

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int a = 0, b = 1;
        if (nums[a] < nums[b]) { // a >= b
            a = 1;
            b = 0;
        }
        for (int i = 2; i < len; ++i) {
            if (nums[i] > nums[a]) {
                b = a;
                a = i;
            } else if (nums[i] > nums[b]) {
                b = i;
            }
        }
        if (nums[b] == 0) {
            return nums[a] != 0 ? a : -1;
        }
        return nums[a] / nums[b] >= 2 ? a : -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.dominantIndex(new int[] {3, 6, 1, 0})); // 1
        System.out.println(slt.dominantIndex(new int[] {1, 2, 3, 4})); // -1
        System.out.println(slt.dominantIndex(new int[] {1})); // 0
        System.out.println(slt.dominantIndex(new int[] {0, 0, 0, 1})); // 0
    }

}
